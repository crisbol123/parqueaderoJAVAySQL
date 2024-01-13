package acceso;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.EnumTipo;
import modelo.Login;

public class LoginDAO {

    Conexion conexion;  // No es necesario inicializar la variable aquí.
    PreparedStatement ps;
    ResultSet rs;
    Connection aux;
    String sql;

    public LoginDAO() {
        conexion = new Conexion();
        aux = conexion.conectar();
    }

    public Login BuscarLogin(int cod) {
        Login l = null;
        try {
            sql = "SELECT TIPO,ID  FROM login WHERE ID=?";
            ps = aux.prepareStatement(sql);
            ps.setLong(1, cod);
            rs = ps.executeQuery();
            while (rs.next()) {
                l = new Login(rs.getInt("ID"),EnumTipo.valueOf(rs.getString("TIPO")));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Login> VerLogin() {
        List<Login> Logins = new ArrayList<>();
        
        try {
            sql = "SELECT * FROM login";
            try (PreparedStatement ps = aux.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Login l = new Login();
                    l.setID(rs.getInt("ID"));
                    l.setTIPO(EnumTipo.valueOf(rs.getString("TIPO")));
                    Logins.add(l);
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return Logins;

    }

    public void LoginOff() throws SQLException {
        conexion.desconectar();
    }
}

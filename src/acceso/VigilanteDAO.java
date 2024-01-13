/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Administrador;
import modelo.Vigilante;
import javax.swing.JOptionPane;
import modelo.EnumTipo;

/**
 *
 * @author Laura
 */
public class VigilanteDAO {
    
    Conexion conexion = new Conexion();
    // Declaración y creación de una instancia de Login2
   
    PreparedStatement ps;
    ResultSet rs;
    Connection aux;
    String sql;

    public VigilanteDAO() {
        conexion = new Conexion();
        aux=conexion.conectar();
       
    }
    
public void AgregarVigilante(Vigilante v) {
    try {
        aux.setAutoCommit(false); // Deshabilitar la confirmación automática

        // El IdAdmin existe en cualquiera de las tablas, ahora puedes agregar el nuevo registro en la tabla vigilante
        String discoSql = "INSERT INTO vigilante (IdVigilante, Nombre, Apellido, Correo, IdAdmin, Celular) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement discoPs = aux.prepareStatement(discoSql);
        discoPs.setInt(1, v.getIdVigilante());
        discoPs.setString(2, v.getNombre());
        discoPs.setString(3, v.getApellido());
        discoPs.setString(4, v.getCorreo());
        discoPs.setInt(5, v.getIdAdmin());
        discoPs.setInt(6, v.getCelular());
        discoPs.executeUpdate();

        // También puedes agregar la inserción en la tabla login aquí si es necesario
        String discoSql2 = "INSERT INTO login (TIPO,ID) VALUES (?, ?)";
        PreparedStatement discoPs2 = aux.prepareStatement(discoSql2);
        discoPs2.setInt(2, v.getIdVigilante());
        discoPs2.setString(1, v.getTIPO().toString());
        discoPs2.executeUpdate();

        aux.commit(); // Confirmar la transacción

    } catch (SQLException ex) {
        try {
            aux.rollback(); // En caso de error, realizar un rollback para deshacer la transacción
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Logger.getLogger(VigilanteDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            aux.setAutoCommit(true); // Restablecer la confirmación automática
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


    
    
    
    


public Vigilante BuscarVigilante(int cod) {
    Vigilante vigilante = null;
    try {
        sql = "SELECT IdVigilante, Nombre, Apellido, Correo,IdAdmin,Celular FROM vigilante WHERE IdVigilante=?";
        ps = aux.prepareStatement(sql);
        ps.setInt(1, cod);
        rs = ps.executeQuery();
        if (rs.next()) {
                        vigilante = new Vigilante(
                rs.getInt("IdVigilante"),
                rs.getString("Nombre"),
                rs.getString("Apellido"),
                rs.getString("Correo"),
                rs.getInt("IdAdmin"), // Replace 0 with the appropriate default value for IdAdmin
                rs.getInt("Celular"), // Replace 0 with the appropriate default value for Celular
                EnumTipo.Vigilante // Replace EnumTipo.Vigilante with the appropriate value
);
           
        }
    } catch (SQLException ex) {
        Logger.getLogger(VigilanteDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return vigilante;
}


      public List<Vigilante> VerVigilante(){
            List<Vigilante> vigilantes=new ArrayList<>();        
        try {
            sql="SELECT * FROM vigilante";
            ps=aux.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Vigilante d= new Vigilante();
                d.setIdVigilante(rs.getInt("IdVigilante"));
                d.setNombre(rs.getString("Nombre"));
                d.setApellido(rs.getString("Apellido"));
                d.setCorreo(rs.getString("Correo"));
                 d.setIdAdmin(rs.getInt("IdAdmin"));
                d.setCelular(rs.getInt("Celular"));
               d.setTIPO(EnumTipo.Vigilante);
                vigilantes.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VigilanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vigilantes; 
    } 
 
public void EliminarVigilante(Vigilante d) {
    try {
        aux.setAutoCommit(false); // Deshabilitar la confirmación automática

        // Eliminar el registro en la tabla "administrador"
        String sqlEliminarAdmin = "DELETE FROM vigilante WHERE IdVigilante = ?";
        try (PreparedStatement psEliminarAdmin = aux.prepareStatement(sqlEliminarAdmin)) {
            psEliminarAdmin.setInt(1, d.getIdVigilante());
            psEliminarAdmin.executeUpdate();
        }

        // Eliminar el registro en la tabla "login"
        String sqlEliminarLogin = "DELETE FROM login WHERE ID=?";
        try (PreparedStatement psEliminarLogin = aux.prepareStatement(sqlEliminarLogin)) {
            psEliminarLogin.setInt(1, d.getIdVigilante());
            psEliminarLogin.executeUpdate();
        }

        aux.commit(); // Confirmar la transacción

    } catch (SQLException ex) {
        try {
            aux.rollback(); // En caso de error, realizar un rollback para deshacer la transacción
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Logger.getLogger(VigilanteDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            aux.setAutoCommit(true); // Restablecer la confirmación automática
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}             
                 
                 
      
     public void EditarVigilante(Vigilante d, int cod) {
    try {
        // Verificar si el nuevo ID ya existe en la tabla "login"
        String verificaIdExistente = "SELECT COUNT(*) FROM login WHERE ID=?";
        try (PreparedStatement psVerificaId = aux.prepareStatement(verificaIdExistente)) {
            psVerificaId.setInt(1, d.getIdVigilante());
            try (ResultSet rs = psVerificaId.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    // El nuevo ID ya existe, puedes manejarlo de acuerdo a tus necesidades.
                    JOptionPane.showMessageDialog(null, "ID ya existe .", "Error", JOptionPane.ERROR_MESSAGE);
                    return;  // O lanzar una excepción, según tu lógica.
                }
            }
        }

        // Actualizar "Vigilante"
        


        String sql = "UPDATE vigilante SET IdVigilante=?, Nombre=?, Apellido=?,Correo=?,IdAdmin=?,Celular=?, TIPO=? WHERE IdVigilante=?";
        try (PreparedStatement ps = aux.prepareStatement(sql)) {
            ps.setInt(1, d.getIdVigilante());
            ps.setString(2, d.getNombre());
            ps.setString(3, d.getApellido());
            ps.setString(4, d.getCorreo());
            ps.setInt(5, d.getIdAdmin());
            ps.setInt(6, d.getCelular());
            ps.setString(7, d.getTIPO().toString());
            ps.setInt(8, cod);
            ps.executeUpdate();
        }

        // Actualizar "login"
        String sq2 = "UPDATE login SET  TIPO= ?, ID=? WHERE ID=?";
        try (PreparedStatement ps2 = aux.prepareStatement(sq2)) {
             ps2.setString(1, d.getTIPO().toString());
         ps2.setInt(2, d.getIdVigilante());
         ps2.setInt(3, cod);
               ps2.executeUpdate();
           
        }

    } catch (SQLException ex) {
        Logger.getLogger(VigilanteDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}




      
     
      
        public void VigilanteOff() throws SQLException{
        conexion.desconectar();
    }
}

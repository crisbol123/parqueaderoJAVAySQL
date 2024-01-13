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
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.EnumTipo;
import modelo.Vigilante;

/**
 *
 * @author Laura
 */
public class AdministradorDAO {
    
    Conexion conexion = new Conexion();
    PreparedStatement ps;
     PreparedStatement ps2;
      PreparedStatement ps3;
    ResultSet rs;
    Connection aux;
    String sql;

    public AdministradorDAO() {
        conexion = new Conexion();
        aux=conexion.conectar();
    }
    

    
public void AgregarAdmin(Administrador a) {
    try {
        aux.setAutoCommit(false); // Deshabilitar la confirmación automática
        // Insertar el disco en la tabla disco con el código de recurso ingresado manualmente
        String discoSql = "INSERT INTO administrador (IdAdministrador, Nombre, Apellido, Correo, Celular) VALUES ( ?, ?, ?, ?, ?)";
        PreparedStatement discoPs = aux.prepareStatement(discoSql);
        discoPs.setInt(1, a.getIdAdministrador()); // Usar el código del recurso como código del disco
        discoPs.setString(2, a.getNombre());
        discoPs.setString(3, a.getApellido());
        discoPs.setString(4, a.getCorreo());
        discoPs.setInt(5, a.getCelular());
        discoPs.executeUpdate();
        String discoSql2 = "INSERT INTO login (TIPO,ID) VALUES ( ?, ?)";
        PreparedStatement discoPs2 = aux.prepareStatement(discoSql2);
        discoPs2.setInt(2, a.getIdAdministrador()); // Usar el código del recurso como código del disco
        discoPs2.setString(1, a.getTIPO().toString());
        discoPs2.executeUpdate();
        aux.commit(); // Confirmar la transacción

    } catch (SQLException ex) {
        try {
            aux.rollback(); // En caso de error, realizar un rollback para deshacer la transacción
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            aux.setAutoCommit(true); // Restablecer la confirmación automática
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
        public Administrador BuscarAdministrador(int cod) {
        Administrador a = null;
        try {
            sql = "SELECT IdAdministrador, Nombre,Apellido, Correo , Celular, TIPO FROM administrador WHERE IdAdministrador=?";
            ps = aux.prepareStatement(sql);
            ps.setLong(1, cod);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Administrador(rs.getInt("IdAdministrador"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Correo"),rs.getInt("Celular"),EnumTipo.valueOf(rs.getString("TIPO"))) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a; 
    }
        
        
             public List<Administrador> VerAdministrador(){
            List<Administrador> administradores=new ArrayList<>();        
        try {
            sql="SELECT * FROM administrador";
            ps=aux.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Administrador d= new Administrador();
                d.setIdAdministrador(rs.getInt("IdAdministrador"));
                d.setNombre(rs.getString("Nombre"));
                d.setApellido(rs.getString("Apellido"));
                d.setCorreo(rs.getString("Correo"));
                d.setCelular(rs.getInt("Celular"));
                administradores.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return administradores; 
    }   
        
       
public void EliminarAdministrador(Administrador d) {
    try {
        aux.setAutoCommit(false); // Deshabilitar la confirmación automática

        // Eliminar el registro en la tabla "administrador"
        String sqlEliminarAdmin = "DELETE FROM administrador WHERE IdAdministrador = ?";
        try (PreparedStatement psEliminarAdmin = aux.prepareStatement(sqlEliminarAdmin)) {
            psEliminarAdmin.setInt(1, d.getIdAdministrador());
            psEliminarAdmin.executeUpdate();
        }

        // Eliminar el registro en la tabla "login"
        String sqlEliminarLogin = "DELETE FROM login WHERE ID=?";
        try (PreparedStatement psEliminarLogin = aux.prepareStatement(sqlEliminarLogin)) {
            psEliminarLogin.setInt(1, d.getIdAdministrador());
            psEliminarLogin.executeUpdate();
        }

        aux.commit(); // Confirmar la transacción

    } catch (SQLException ex) {
        try {
            aux.rollback(); // En caso de error, realizar un rollback para deshacer la transacción
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            aux.setAutoCommit(true); // Restablecer la confirmación automática
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

          
 
 
 
     public Administrador BuscarAdmin (int cod) {
        Administrador d = null;
        try {
            sql = "SELECT IdAdministrador, Nombre,Apellido, Correo , Celular FROM administrador WHERE IdAdministrador=?";
            ps = aux.prepareStatement(sql);
            ps.setLong(1, cod);
            rs = ps.executeQuery();
           
            String sq2 = "SELECT TIPO,ID FROM login WHERE ID=?";
            PreparedStatement ps3 = aux.prepareStatement(sq2);
            ps3.setLong(1, cod);
            ResultSet rs2 = ps3.executeQuery();
            
            
            
            while (rs.next()) {
                d = new Administrador(rs.getInt("IdAdministrador"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Correo"),rs.getInt("Celular"),EnumTipo.valueOf(rs.getString("TIPO")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d; 
    }
 
 
     
     public void EditarAdmin(Administrador d, int cod) {
    try {
        // Verificar si el nuevo ID ya existe en la tabla "login"
        String verificaIdExistente = "SELECT COUNT(*) FROM login WHERE ID=?";
        try (PreparedStatement psVerificaId = aux.prepareStatement(verificaIdExistente)) {
            psVerificaId.setInt(1, d.getIdAdministrador());
            try (ResultSet rs = psVerificaId.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    // El nuevo ID ya existe, puedes manejarlo de acuerdo a tus necesidades.
                    JOptionPane.showMessageDialog(null, "ID ya existe .", "Error", JOptionPane.ERROR_MESSAGE);
                    return;  // O lanzar una excepción, según tu lógica.
                }
            }
        }

        // Actualizar "administrador"
        String sql = "UPDATE administrador SET IdAdministrador=?, Nombre=?, Apellido=?, Correo=?, Celular=? WHERE IdAdministrador=?";
        try (PreparedStatement ps = aux.prepareStatement(sql)) {
            ps.setInt(1, d.getIdAdministrador());
            ps.setString(2, d.getNombre());
            ps.setString(3, d.getApellido());
            ps.setString(4, d.getCorreo());
            ps.setInt(5, d.getCelular());
            ps.setInt(6, cod);
            ps.executeUpdate();
        }

        // Actualizar "login"
        String sq2 = "UPDATE login SET  TIPO= ?, ID=? WHERE ID=?";
        try (PreparedStatement ps2 = aux.prepareStatement(sq2)) {
             ps2.setString(1, d.getTIPO().toString());
         ps2.setInt(2, d.getIdAdministrador());
         ps2.setInt(3, cod);
               ps2.executeUpdate();
           
        }

    } catch (SQLException ex) {
        Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}

     
     
    
 
   
        
        
       

     
 
        public void AdministradorOff() throws SQLException{
        conexion.desconectar();
    }
}

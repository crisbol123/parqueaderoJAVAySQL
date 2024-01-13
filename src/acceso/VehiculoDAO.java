/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso;

import java.sql.Connection;
import java.sql.Date;
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
import modelo.Vehiculo;

/**
 *
 * @author Laura
 */
public class VehiculoDAO {
    
    Conexion conexion = new Conexion();
    // Declaración y creación de una instancia de Login2
   
    PreparedStatement ps;
    ResultSet rs;
    Connection aux;
    String sql;

    public VehiculoDAO() {
        conexion = new Conexion();
        aux=conexion.conectar();
       
    }
    

  public void AgregarVehiculo(Vehiculo v) {
    try {
        aux.setAutoCommit(false); // Deshabilitar la confirmación automática

        // El IdAdmin existe, ahora puedes agregar el nuevo registro en la tabla vigilante
        String discoSql = "INSERT INTO vehiculo (Placa, NombreUsuario, EnumVehiculo, Bahia, HoraEntrada, estado) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement discoPs = aux.prepareStatement(discoSql);
        discoPs.setString(1, v.getPlaca());
        discoPs.setString(2, v.getNombreUsuario());
        discoPs.setString(3, v.getEnumVehiculo());
        discoPs.setInt(4, v.getBahia());
        discoPs.setString(5,  v.getHoraEntrada());
        discoPs.setString(6, v.getEstado());
        discoPs.executeUpdate();
        aux.commit(); // Confirmar la transacción
            JOptionPane.showMessageDialog(null,"Vehiculo Registrado");
    } catch (SQLException ex) {
        try {
            aux.rollback(); // En caso de error, realizar un rollback para deshacer la transacción
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            aux.setAutoCommit(true); // Restablecer la confirmación automática
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    public Vehiculo BuscarVehiculo(String ced){
        Vehiculo u=null;
        try {
            sql="SELECT Placa, NombreUsuario, EnumVehiculo, Bahia, HoraEntrada, estado FROM vehiculo WHERE placa=?";
            ps=aux.prepareStatement(sql);
            ps.setString(1, ced);
            rs=ps.executeQuery();
            while(rs.next()){
                u= new Vehiculo(rs.getString("Placa"), rs.getString("NombreUsuario"),rs.getInt("Bahia"),rs.getString("EnumVehiculo"),rs.getString("HoraEntrada"),rs.getString("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u; 
    }

      public List<Vehiculo> VerVehiculo(){
            List<Vehiculo> vehiculos=new ArrayList<>();        
        try {
            sql="SELECT * FROM vehiculo";
            ps=aux.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Vehiculo d= new Vehiculo();
                d.setPlaca(rs.getString("Placa"));
                d.setNombreUsuario(rs.getString("NombreUsuario"));
                d.setBahia(rs.getInt("Bahia"));
                d.setEnumVehiculo(rs.getString("EnumVehiculo"));
                 d.setHoraEntrada(rs.getString("HoraEntrada"));
                d.setEstado(rs.getString("estado"));
               
                vehiculos.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculos; 
    } 
 
      public void EliminarVehiculo(Vehiculo d) {
    try {
        String sql = "DELETE FROM vehiculo WHERE Placa=?";
        ps = aux.prepareStatement(sql);
        
        ps.setString(1, d.getPlaca());
       
        ps.executeUpdate();
        
    } catch (SQLException ex) {
        
        Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}             
                 
                 
public void EditarVehiculo(Vehiculo d, int cod) {
    try {
      
        // El IdAdmin existe, ahora puedes realizar la actualización en la tabla vigilante
        String sql = "UPDATE vehiculo SET Placa=?, NombreUsuario=?, EnumVehiculo=?, Bahia=?, HoraEntrada=?, estado=? WHERE Placa=?";
        ps = aux.prepareStatement(sql);
        ps.setString(1, d.getPlaca());
        ps.setString(2, d.getNombreUsuario());
        ps.setString(3, d.getEnumVehiculo());
        ps.setInt(4, d.getBahia());
        ps.setString(5, d.getHoraEntrada());
        ps.setString(6, d.getEstado());
        
        ps.setInt(7, cod); // Establece la condición WHERE con la llave primaria existente
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}

      
     
      
        public void VehiculoOff() throws SQLException{
        conexion.desconectar();
    }
}

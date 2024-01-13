/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class Conexion {
    
    Connection con;
    String url;
    String usuario;


    public Conexion() {
    url = "jdbc:mysql://localhost/parqueadero";
    usuario = "root";
    }

    public Connection conectar(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, usuario, "");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
               return con;
    }
    
    public void desconectar() throws SQLException{
            if(con!= null){
                 con.close();
                }
    }
}

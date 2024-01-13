/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package usuariobiblioteca;

import gui.BuscarVehiculo;
import gui.ListarVehiculo;
import gui.LoginPrincipal;
import gui.UsuarioVista;
import java.io.IOException;
import server.Servidor;

/**
 *
 * @author Laura
 */
public class UsuarioBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          LoginPrincipal vista = new LoginPrincipal();
          
         vista.setVisible(true);
         vista.setLocationRelativeTo(null);
         try {
            Servidor objServidor= new Servidor(5000);
            objServidor.ejecutarServidor();
        } catch (IOException ex) {
            System.out.println("Error al ejecutar el servidor");
        }
    }
    
}

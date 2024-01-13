/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import modelo.Vehiculo;

/**
 *
 * @author Laura
 */
public class Servidor {
    private ServerSocket objServidor; 
    private Socket objSocket;
    private DataInputStream objFlujoDeEntrada;
    private DataOutputStream objFlujoDeSalida;
    private OutputStream outputStream;
    private ObjectOutputStream objOutput;
   
    public Servidor(int puerto) throws IOException {
         objServidor = new ServerSocket(puerto);
    }
    
    
    public  void ejecutarServidor() {
     Servicio objServicio=new Servicio();
     Vehiculo us;
     String cedula;
        try {
            System.out.println("Servidor iniciado"); 
            while (true) {
                objSocket = objServidor.accept();
                System.out.println("Cliente nuevo conectado");
                //Habilitar los flujos de datos
               outputStream = objSocket.getOutputStream();
                objOutput = new ObjectOutputStream(outputStream);
                objFlujoDeEntrada = new DataInputStream(objSocket.getInputStream());
                objFlujoDeSalida = new DataOutputStream(objSocket.getOutputStream());
                System.out.println("Flujo de datos habilitado");
                 cedula = objFlujoDeEntrada.readUTF();
                 us=objServicio.encontrarVehiculo(cedula);
                 objOutput.writeObject((Vehiculo) us);
                // objFlujoDeSalida.writeUTF(us.getNombre());
                objSocket.close(); //El servidor cierra el socket con el cliente
                System.out.println("Cliente desconectado");
            }
        } catch (IOException | NullPointerException ex) {
            System.out.println("error de conexión por: "+ex);
        }
 
    }
}

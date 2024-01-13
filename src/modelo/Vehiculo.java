/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Laura
 */
public class Vehiculo implements Serializable{
    private String Placa;
    private String NombreUsuario;
    private int Bahia;
    private String EnumVehiculo;
    private String HoraEntrada;
    private String estado;
   

    public Vehiculo() {
        
    }

    public Vehiculo(String Placa, String NombreUsuario,int Bahia, String EnumVehiculo, String HoraEntrada,String estado ) {
        this.Placa = Placa;
        this.NombreUsuario = NombreUsuario;
        this.Bahia = Bahia;
        this.EnumVehiculo = EnumVehiculo;
        this.HoraEntrada = HoraEntrada;
        this.estado = estado;
   
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public int getBahia() {
        return Bahia;
    }

    public void setBahia(int Bahia) {
        this.Bahia = Bahia;
    }

    public String getEnumVehiculo() {
        return EnumVehiculo;
    }

    public void setEnumVehiculo(String EnumVehiculo) {
        this.EnumVehiculo = EnumVehiculo;
    }

    public String getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(String HoraEntrada) {
        this.HoraEntrada = HoraEntrada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    
    
}

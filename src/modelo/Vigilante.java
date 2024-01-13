/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.EnumTipo;


/**
 *
 * @author Laura
 */
public class Vigilante {
    private int IdVigilante;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private int IdAdmin;
    private int Celular;
    private EnumTipo TIPO;

    public Vigilante() {
        
    }

    public Vigilante(int IdVigilante, String Nombre, String Apellido, String Correo, int IdAdmin, int Celular, EnumTipo TIPO) {
        this.IdVigilante = IdVigilante;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.IdAdmin = IdAdmin;
        this.Celular = Celular;
        this.TIPO=TIPO;
    }

    public int getIdVigilante() {
        return IdVigilante;
    }

    public void setIdVigilante(int IdVigilante) {
        this.IdVigilante = IdVigilante;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getIdAdmin() {
        return IdAdmin;
    }

    public void setIdAdmin(int IdAdmin) {
        this.IdAdmin = IdAdmin;
    }

    public int getCelular() {
        return Celular;
    }

    public void setCelular(int Celular) {
        this.Celular = Celular;
    }

    public EnumTipo getTIPO() {
        return TIPO;
    }

    public void setTIPO(EnumTipo TIPO) {
        this.TIPO = TIPO;
    }

    
    
}

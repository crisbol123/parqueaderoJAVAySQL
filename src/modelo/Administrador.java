/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Laura
 */
public class Administrador {
    private int IdAdministrador ;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private int Celular;
    private EnumTipo TIPO;

    public Administrador() {
    }

    public Administrador(int IdAdministrador, String Nombre, String Apellido, String Correo, int Celular, EnumTipo TIPO) {
        this.IdAdministrador = IdAdministrador;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
       this.TIPO=TIPO;
        this.Celular = Celular;
    }

    public int getIdAdministrador() {
        return IdAdministrador;
    }

    public void setIdAdministrador(int IdAdministrador) {
        this.IdAdministrador = IdAdministrador;
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

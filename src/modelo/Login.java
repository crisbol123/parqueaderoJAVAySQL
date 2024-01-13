package modelo;

public class Login {
    private int ID;
    private EnumTipo TIPO; // Cambio el nombre del campo a "Genero" y el tipo a EnumGenero

    public Login() {
    }

    public Login(int ID, EnumTipo TIPO) {
        
        this.ID = ID;
        this.TIPO = TIPO;
    }

     public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public EnumTipo getTIPO() {
        return TIPO;
    }

    public void setTIPO(EnumTipo TIPO) {
        this.TIPO = TIPO;
    }

 

}

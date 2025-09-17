
package modelo;

public class Palabras {
    private int Id_Palabra;
    private String nombre_Palabra;
    private String pista_Uno;
    private String pista_Dos;
    private String pista_Tres;

    public Palabras() {
    }

    public Palabras(int Id_Palabra, String nombre_Palabra, String pista_Uno, String pista_Dos, String pista_Tres) {
        this.Id_Palabra = Id_Palabra;
        this.nombre_Palabra = nombre_Palabra;
        this.pista_Uno = pista_Uno;
        this.pista_Dos = pista_Dos;
        this.pista_Tres = pista_Tres;
    }       

    public int getId_Palabra() {
        return Id_Palabra;
    }

    public void setId_Palabra(int Id_Palabra) {
        this.Id_Palabra = Id_Palabra;
    }

    public String getNombre_Palabra() {
        return nombre_Palabra;
    }

    public void setNombre_Palabra(String nombre_Palabra) {
        this.nombre_Palabra = nombre_Palabra;
    }

    public String getPista_Uno() {
        return pista_Uno;
    }

    public void setPista_Uno(String pista_Uno) {
        this.pista_Uno = pista_Uno;
    }

    public String getPista_Dos() {
        return pista_Dos;
    }

    public void setPista_Dos(String pista_Dos) {
        this.pista_Dos = pista_Dos;
    }

    public String getPista_Tres() {
        return pista_Tres;
    }

    public void setPista_Tres(String pista_Tres) {
        this.pista_Tres = pista_Tres;
    }

    
    
}
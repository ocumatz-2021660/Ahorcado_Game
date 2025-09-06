
package modelo;

public class Palabras {
    private int IDPalabra;
    private String nombrePalabra;
    private String pistaUno;
    private String pistaDos;
    private String pistaTres;

    public Palabras() {
    }

    public Palabras(int IDPalabra, String nombrePalabra, String pistaUno, String pistaDos, String pistaTres) {
        this.IDPalabra = IDPalabra;
        this.nombrePalabra = nombrePalabra;
        this.pistaUno = pistaUno;
        this.pistaDos = pistaDos;
        this.pistaTres = pistaTres;
    }

    public int getIDPalabra() {
        return IDPalabra;
    }

    public void setIDPalabra(int IDPalabra) {
        this.IDPalabra = IDPalabra;
    }

    public String getNombrePalabra() {
        return nombrePalabra;
    }

    public void setNombrePalabra(String nombrePalabra) {
        this.nombrePalabra = nombrePalabra;
    }

    public String getPistaUno() {
        return pistaUno;
    }

    public void setPistaUno(String pistaUno) {
        this.pistaUno = pistaUno;
    }

    public String getPistaDos() {
        return pistaDos;
    }

    public void setPistaDos(String pistaDos) {
        this.pistaDos = pistaDos;
    }

    public String getPistaTres() {
        return pistaTres;
    }

    public void setPistaTres(String pistaTres) {
        this.pistaTres = pistaTres;
    }

    @Override
    public String toString() {
        return "Palabras{" + "IDPalabra=" + IDPalabra + ", nombrePalabra=" + nombrePalabra + ", pistaUno=" + pistaUno + ", pistaDos=" + pistaDos + ", pistaTres=" + pistaTres + '}';
    }
    
    
}

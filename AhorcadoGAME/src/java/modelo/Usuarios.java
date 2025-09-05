
package modelo;

public class Usuarios {
private int IDusuario;
private String nombreUsuario;
private String contrasena;

    public Usuarios() {
    }

    public Usuarios(int IDusuario, String nombreUsuario, String contrasena) {
        this.IDusuario = IDusuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public int getIDusuario() {
        return IDusuario;
    }

    public void setIDusuario(int IDusuario) {
        this.IDusuario = IDusuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "IDusuario=" + IDusuario + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + '}';
    }


}

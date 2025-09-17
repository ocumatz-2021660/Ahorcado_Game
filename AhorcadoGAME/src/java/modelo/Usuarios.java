
package modelo;

public class Usuarios {
private int Id_Usuario;
private String nombre_Usuario;
private String contrasena;

    public Usuarios() {
    }

    public Usuarios(int Id_Usuario, String nombre_Usuario, String contrasena) {
        this.Id_Usuario = Id_Usuario;
        this.nombre_Usuario = nombre_Usuario;
        this.contrasena = contrasena;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


}

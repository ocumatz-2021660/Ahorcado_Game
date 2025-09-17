package com.oscarcumatz.Ahorcado.model;

import jakarta.persistence.*;

@Entity
@Table (name = "usuarios")

public class Usuarios {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer Id_Usuario;

    @Column (name = "nombre_Usuario")
    private String nombre_Usuario;

    @Column (name = "contrasena")
    private String contrasena;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(Integer id_Usuario) {
        Id_Usuario = id_Usuario;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }
}

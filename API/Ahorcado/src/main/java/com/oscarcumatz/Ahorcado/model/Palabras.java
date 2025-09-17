package com.oscarcumatz.Ahorcado.model;

import jakarta.persistence.*;

@Entity
@Table (name = "Palabras")

public class Palabras {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer Id_Palabra;
    @Column (name = "nombre_Palabra")
    private String nombre_Palabra;
    @Column (name = "pista_Uno")
    private String pista_Uno;
    @Column (name = "pista_Dos")
    private  String pista_Dos;
    @Column (name = "pista_Tres")
    private String pista_Tres;

    public Integer getId_Palabra() {
        return Id_Palabra;
    }

    public void setId_Palabra(Integer id_Palabra) {
        Id_Palabra = id_Palabra;
    }

    public String getNombre_Palabra() {
        return nombre_Palabra;
    }

    public void setNombre_Palabra(String nombre_Palabra) {
        this.nombre_Palabra = nombre_Palabra;
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

    public String getPista_Uno() {
        return pista_Uno;
    }

    public void setPista_Uno(String pista_Uno) {
        this.pista_Uno = pista_Uno;
    }
}

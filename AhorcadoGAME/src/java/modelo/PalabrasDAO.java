package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalabrasDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listarPalabras() {

        String sql = " call sp_MostrarPalabra();";
        List<Palabras> listaPalabras = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Palabras words = new Palabras();
                words.setId_Palabra(rs.getInt(1));
                words.setNombre_Palabra(rs.getString(2));
                words.setPista_Uno(rs.getString(3));
                words.setPista_Dos(rs.getString(4));
                words.setPista_Tres(rs.getString(5));

                listaPalabras.add(words);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPalabras;
    }

    public Palabras buscarPalabra(int id) {
        String sql = "call sp_BuscarPalabra(?);";
        Palabras word = null; // Inicializar en null
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                word = new Palabras();
                word.setId_Palabra(rs.getInt(1));
                word.setNombre_Palabra(rs.getString(2));
                word.setPista_Uno(rs.getString(3));
                word.setPista_Dos(rs.getString(4));
                word.setPista_Tres(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return word;
    }

    public int cantidadPalabras() {
        String sql = "call sp_ContarPalabras();";
        int cantidad = 0;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cantidad;
    }    
    //metodo para escojer la palabra
    public Palabras obtenerPalabraAleatoria() {
        Palabras palabra = null;
        // en en el metodo se busca una palabra aleatoria y la traemos para agrgarla al proyecto
        String sql = "call sp_PalabraRandom();";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                palabra = new Palabras();
                palabra.setId_Palabra(rs.getInt(1));
                palabra.setNombre_Palabra(rs.getString(2));
                palabra.setPista_Uno(rs.getString(3));
                palabra.setPista_Dos(rs.getString(4));
                palabra.setPista_Tres(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener palabra aleatoria");
        } 
        return palabra;
    }
}



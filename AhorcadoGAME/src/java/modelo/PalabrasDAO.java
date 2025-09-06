package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
                words.setIDPalabra(rs.getInt(1));
                words.setNombrePalabra(rs.getString(2));
                words.setPistaUno(rs.getString(3));
                words.setPistaDos(rs.getString(4));
                words.setPistaTres(rs.getString(5));

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
                word.setIDPalabra(rs.getInt(1));
                word.setNombrePalabra(rs.getString(2));
                word.setPistaUno(rs.getString(3));
                word.setPistaDos(rs.getString(4));
                word.setPistaTres(rs.getString(5));
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
}

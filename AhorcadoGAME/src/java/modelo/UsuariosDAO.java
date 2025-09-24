package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    //metodo para validar
    public Usuarios validar(String name, String pass) {
        Usuarios usuarios = new Usuarios();
        //procedimiento almacenado 
        String sql = "call sp_ValidarUsuario(?, ?);";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuarios.setId_Usuario(rs.getInt("Id_Usuario"));
                usuarios.setNombre_Usuario(rs.getString("nombre_Usuario"));
                usuarios.setContrasena(rs.getString("contrasena"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Los campos no coinciden");
        }
        return usuarios;
    }

}
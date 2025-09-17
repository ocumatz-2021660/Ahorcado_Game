package com.oscarcumatz.Ahorcado.Service;

import com.oscarcumatz.Ahorcado.model.Usuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUsuarioService {
    List<Usuarios> listarUsuarios();
    Usuarios buscarUserPorID(Integer Id_Usuario);
    Usuarios guardarUsuario (Usuarios usuarios);
    Usuarios actualizarUsuario (Integer Id_Usuario, Usuarios usuarios);
    boolean eliminarUsuario(Integer Id_Usuario);

}

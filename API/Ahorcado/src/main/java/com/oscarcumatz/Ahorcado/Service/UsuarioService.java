package com.oscarcumatz.Ahorcado.Service;

import com.oscarcumatz.Ahorcado.model.Usuarios;
import com.oscarcumatz.Ahorcado.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public List<Usuarios> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuarios buscarUserPorID(Integer Id_Usuario) {
        return usuarioRepository.findById(Id_Usuario).orElse(null);
    }

    @Override
    public Usuarios guardarUsuario(Usuarios usuarios) {
        List<Usuarios> listaUsuarios = usuarioRepository.findAll();
        for (Usuarios usuarioRegistrado : listaUsuarios){
            if(usuarioRegistrado.getNombre_Usuario().equalsIgnoreCase(usuarios.getNombre_Usuario())){
                usuarios.setNombre_Usuario("EnUso");
                return usuarios;
            }
            if (usuarios.getNombre_Usuario() == null || usuarios.getNombre_Usuario().trim().isEmpty() ||
                    usuarios.getContrasena() == null || usuarios.getContrasena().trim().isEmpty()) {
                usuarios.setNombre_Usuario("Vasio");
                return usuarios;
            }
            if(usuarios.getNombre_Usuario().length() > 100 || usuarios.getContrasena().length() > 100){
                usuarios.setNombre_Usuario("Maximo");
                return usuarios;
            }
        }
        return usuarioRepository.save(usuarios);
    }

    @Override
    public Usuarios actualizarUsuario(Integer Id_Usuario, Usuarios usuarios) {
        Usuarios updateUser = usuarioRepository.findById(Id_Usuario).orElse(null);

        if(updateUser != null){
            List<Usuarios> listaUsuarios = usuarioRepository.findAll();
            for (Usuarios usuarioRegistrado : listaUsuarios){
                if(usuarioRegistrado.getNombre_Usuario().equalsIgnoreCase(usuarios.getNombre_Usuario())){
                    usuarios.setNombre_Usuario("EnUso");
                    return usuarios;
                }
                if (usuarios.getNombre_Usuario() == null || usuarios.getNombre_Usuario().trim().isEmpty() ||
                        usuarios.getContrasena() == null || usuarios.getContrasena().trim().isEmpty()) {
                    usuarios.setNombre_Usuario("Vasio");
                    return usuarios;
                }
                if(usuarios.getNombre_Usuario().length() > 100 || usuarios.getContrasena().length() > 100){
                    usuarios.setNombre_Usuario("Maximo");
                    return usuarios;
                }
            }
            updateUser.setNombre_Usuario(usuarios.getNombre_Usuario());
            updateUser.setContrasena(usuarios.getContrasena());
            return usuarioRepository.save(updateUser);
        }
        return null;
    }

    @Override
    public boolean eliminarUsuario(Integer Id_Usuario) {
        if(usuarioRepository.existsById(Id_Usuario)){
            usuarioRepository.deleteById(Id_Usuario);
            return true;
        }
        return false;
    }
}

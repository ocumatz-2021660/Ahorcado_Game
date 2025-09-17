package com.oscarcumatz.Ahorcado.controller;

import com.oscarcumatz.Ahorcado.Service.UsuarioService;
import com.oscarcumatz.Ahorcado.model.Usuarios;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/usuarios")

public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuarios> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }
    @GetMapping ("/{Id_Usuario}")
    public Usuarios buscarUserPorID(@PathVariable Integer Id_Usuario){
        return usuarioService.buscarUserPorID(Id_Usuario);
    }
    @PostMapping
    public String guardarUsuario(@RequestBody Usuarios usuarios){
        Usuarios newUsuario = usuarioService.guardarUsuario(usuarios);
        if ("Vasio".equals(newUsuario.getNombre_Usuario())) {
            return "Todos los campos deben estar llenos";
        }
        if("Maximo".equals(newUsuario.getNombre_Usuario())){
            return "El nombre exede los caracteres permitidos (100)";
        }
        if("EnUso".equals(newUsuario.getNombre_Usuario())){
            return "El nombre ya esta en uso, escoja otro porfavor";
        }
        return "Usuario agregado correctamente";
    }

    @PutMapping ("/{Id_Usuario}")
    public String actualizarUsuario(@PathVariable Integer Id_Usuario ,@RequestBody Usuarios usuarios){
        Usuarios updateUsuario = usuarioService.actualizarUsuario(Id_Usuario ,usuarios);
        if(updateUsuario == null){
            return "El Usuario no existe en los registros";
        }
        if ("Vasio".equals(updateUsuario.getNombre_Usuario())) {
            return "Todos los campos deben estar llenos";
        }
        if("Maximo".equals(updateUsuario.getNombre_Usuario())){
            return "El nombre exede los caracteres permitidos (100)";
        }
        if("EnUso".equals(updateUsuario.getNombre_Usuario())){
            return "El nombre ya esta en uso, escoja otro porfavor";
        }
        return "Usuario Actualizado correctamente";
    }
    @DeleteMapping ("/{Id_Usuario}")
    public String eliminarUsuario(@PathVariable Integer Id_Usuario){
        boolean usuarioEliminado = usuarioService.eliminarUsuario(Id_Usuario);
        if(usuarioEliminado){
            return "Usuario eliminado correctamente";
        }else{
            return "El Usuario no existe en los registros";
        }
    }
}


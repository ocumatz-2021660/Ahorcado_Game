package com.oscarcumatz.Ahorcado.controller;

import com.oscarcumatz.Ahorcado.Service.PalabrasService;
import com.oscarcumatz.Ahorcado.model.Palabras;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/palabras")

public class PalabrasController {

    private final PalabrasService palabrasService;

    public PalabrasController(PalabrasService palabrasService) {
        this.palabrasService = palabrasService;
    }
    @GetMapping
    public List<Palabras> listarPalabras(){
        return palabrasService.listarPalabras();
    }
    @GetMapping ("/{Id_Palabra}")
    public Palabras buscarPalabraPorId(@PathVariable Integer Id_Palabra){
        return palabrasService.buscarPalabraPorId(Id_Palabra);
    }
    @PostMapping
    public String guardarPalabras(@RequestBody Palabras palabras){
        Palabras newPalabra = palabrasService.guardarPalabras(palabras);
        if("Vasio".equals(newPalabra.getNombre_Palabra())){
            return "Todos los campos deben estar llenos";
        }
        if("EnUso".equals(newPalabra.getNombre_Palabra())){
            return "La palabra ya existe en los registros";
        }
        if("Minimo".equals(newPalabra.getNombre_Palabra())){
            return "El minimo de caracteres para las palabras es de 8 caracteres";
        }
        if("Maximo".equals(newPalabra.getNombre_Palabra())){
            return "El nombre de la palabra no puede revasar los 100 caracteres";
        }
        if("MaximoPistas".equals(newPalabra.getNombre_Palabra())){
            return "Las pistas no pueden revasar los 250 caracteres";
        }
        return "Palabra agregada correctamente";
    }
    @PutMapping ("/{Id_Palabra}")
    public String actualizarPalabras(@PathVariable Integer Id_Palabra, @RequestBody Palabras palabras){
        Palabras updatePalabras = palabrasService.actualizarPalabras(Id_Palabra, palabras);
        if(updatePalabras == null){
            return "La palabra no existe en los registros";
        }
        if("Vasio".equals(updatePalabras.getNombre_Palabra())){
            return "todos los campos deben estar llenos";
        }
        if("EnUso".equals(updatePalabras.getNombre_Palabra())){
            return "La palabra ya existe en los registros";
        }
        if("Minimo".equals(updatePalabras.getNombre_Palabra())){
            return "El minimo de caracteres para las palabras es de 8 caracteres";
        }
        if("Maximo".equals(updatePalabras.getNombre_Palabra())){
            return "El nombre de la palabra no puede revasar los 100 caracteres";
        }
        if("MaximoPistas".equals(updatePalabras.getNombre_Palabra())){
            return "Las pistas no pueden revasar los 250 caracteres";
        }
        return "Palabra Actualizada correctamente";
    }
    @DeleteMapping ("/{Id_Palabra}")
    public String elimiarPalabra (@PathVariable Integer Id_Palabra){
        boolean palabraEliminada = palabrasService.elimiarPalabra(Id_Palabra);
        if(palabraEliminada){
            return "Palabra eliminada correctamente";
        }else{
            return "La palabra seleccionada no existe en los registros";
        }

    }
}

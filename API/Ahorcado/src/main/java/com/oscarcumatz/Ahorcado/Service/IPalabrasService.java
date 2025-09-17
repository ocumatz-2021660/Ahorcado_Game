package com.oscarcumatz.Ahorcado.Service;

import com.oscarcumatz.Ahorcado.model.Palabras;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPalabrasService {
    List<Palabras> listarPalabras();
    Palabras buscarPalabraPorId(Integer Id_Palabra);
    Palabras guardarPalabras(Palabras palabras);
    Palabras actualizarPalabras(Integer Id_Palabra, Palabras palabras);
    boolean elimiarPalabra(Integer Id_Palabra);
}

package com.oscarcumatz.Ahorcado.Service;

import com.oscarcumatz.Ahorcado.model.Palabras;
import com.oscarcumatz.Ahorcado.repository.PalabrasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalabrasService implements IPalabrasService{

    private final PalabrasRepository palabrasRepository;

    public PalabrasService(PalabrasRepository palabrasRepository) {
        this.palabrasRepository = palabrasRepository;
    }

    @Override
    public List<Palabras> listarPalabras() {
        return palabrasRepository.findAll();
    }

    @Override
    public Palabras buscarPalabraPorId(Integer Id_Palabra) {
        return palabrasRepository.findById(Id_Palabra).orElse(null);
    }

    @Override
    public Palabras guardarPalabras(Palabras palabras) {
        List<Palabras> listaPalabras = palabrasRepository.findAll();
        for (Palabras palabraAgregada : listaPalabras){
            if(palabraAgregada.getNombre_Palabra().equalsIgnoreCase(palabras.getNombre_Palabra())){
                palabras.setNombre_Palabra("EnUso");
                return palabras;
            }
            if(palabras.getNombre_Palabra() == null || palabras.getNombre_Palabra().trim().isEmpty() ||
            palabras.getPista_Uno() == null || palabras.getPista_Uno().trim().isEmpty() ||
            palabras.getPista_Dos() == null || palabras.getPista_Dos().trim().isEmpty() ||
            palabras.getPista_Tres() == null || palabras.getPista_Tres().trim().isEmpty()){
                palabras.setNombre_Palabra("Vasio");
                return palabras;
            }
        }
        return palabrasRepository.save(palabras);
    }

    @Override
    public Palabras actualizarPalabras(Integer Id_Palabra, Palabras palabras) {
        Palabras updatePalabra = palabrasRepository.findById(Id_Palabra).orElse(null);
        if(updatePalabra != null){
            List<Palabras> listaPalabras = palabrasRepository.findAll();
            for (Palabras palabraAgregada : listaPalabras){
                if(palabraAgregada.getNombre_Palabra().equalsIgnoreCase(palabras.getNombre_Palabra())){
                    palabras.setNombre_Palabra("EnUso");
                    return palabras;
                }
                if(palabras.getNombre_Palabra() == null || palabras.getNombre_Palabra().trim().isEmpty() ||
                        palabras.getPista_Uno() == null || palabras.getPista_Uno().trim().isEmpty() ||
                        palabras.getPista_Dos() == null || palabras.getPista_Dos().trim().isEmpty() ||
                        palabras.getPista_Tres() == null || palabras.getPista_Tres().trim().isEmpty()){
                    palabras.setNombre_Palabra("Vasio");
                    return palabras;
                }
            }
            updatePalabra.setNombre_Palabra(palabras.getNombre_Palabra());
            updatePalabra.setPista_Uno(palabras.getPista_Uno());
            updatePalabra.setPista_Dos(palabras.getPista_Dos());
            updatePalabra.setPista_Tres(palabras.getPista_Tres());
            return palabrasRepository.save(updatePalabra);
        }
        return null;
    }

    @Override
    public boolean elimiarPalabra(Integer Id_Palabra) {
        if (palabrasRepository.existsById(Id_Palabra)){
            palabrasRepository.deleteById(Id_Palabra);
            return true;
        }
        return false;
    }
}

package com.oscarcumatz.Ahorcado.repository;

import com.oscarcumatz.Ahorcado.model.Palabras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalabrasRepository extends JpaRepository <Palabras, Integer> {
}

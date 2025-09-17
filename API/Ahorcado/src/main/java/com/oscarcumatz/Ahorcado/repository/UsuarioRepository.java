package com.oscarcumatz.Ahorcado.repository;

import com.oscarcumatz.Ahorcado.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios , Integer> {
}

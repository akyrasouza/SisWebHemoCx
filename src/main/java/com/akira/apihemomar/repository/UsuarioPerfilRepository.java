package com.akira.apihemomar.repository;

import com.akira.apihemomar.models.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil,Long> {
}

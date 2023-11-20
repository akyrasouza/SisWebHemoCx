package com.akira.apihemomar.repository;

import com.akira.apihemomar.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmailIgnoreCase(String email);
    Optional<Usuario> findByCpf(String cpf);
    Optional<Usuario> findByLogin(String login);
    Optional<Usuario> findByEmail(String email);

}

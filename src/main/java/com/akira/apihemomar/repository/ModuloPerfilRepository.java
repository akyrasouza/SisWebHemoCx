package com.akira.apihemomar.repository;

import com.akira.apihemomar.models.ModuloPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuloPerfilRepository extends JpaRepository<ModuloPerfil,Long> {

    @Query(value = "select  mp.* from tb14_modulo_perfil mp\n" +
            "join tb07_usuario_perfil up on  up.fktb07tb01_cod_usuario =:usuarioId\n" +
            "and up.fktb07tb06_cod_perfil =mp.fktb14tb07_cod_perfil",nativeQuery = true)
    List<ModuloPerfil> buscarModulosPerfilUsuario(Long usuarioId);
}

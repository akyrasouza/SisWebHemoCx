package com.akira.apihemomar.services;

import com.akira.apihemomar.models.ModuloPerfil;
import com.akira.apihemomar.repository.ModuloPerfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuloPerfilService {
    private final ModuloPerfilRepository  moduloPerfilRepository;
    public ModuloPerfilService(ModuloPerfilRepository moduloPerfilRepository) {
        this.moduloPerfilRepository = moduloPerfilRepository;
    }

    public List<ModuloPerfil> buscarModulosPerfilUsuario(Long usuarioId){
        return moduloPerfilRepository.buscarModulosPerfilUsuario(usuarioId);
    }
}

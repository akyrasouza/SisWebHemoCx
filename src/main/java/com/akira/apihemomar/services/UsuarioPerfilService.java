package com.akira.apihemomar.services;


import com.akira.apihemomar.models.Perfil;
import com.akira.apihemomar.models.Usuario;
import com.akira.apihemomar.models.UsuarioPerfil;
import com.akira.apihemomar.repository.UsuarioPerfilRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UsuarioPerfilService {
    private final UsuarioPerfilRepository  usuarioPerfilRepository;
    public UsuarioPerfilService(UsuarioPerfilRepository usuarioPerfilRepository) {
        this.usuarioPerfilRepository = usuarioPerfilRepository;
    }
    @Transactional
    public void cadastrarPerfilUsuario(Usuario usuario, Long perfilId){
        UsuarioPerfil  usuarioPerfil=new UsuarioPerfil();
        usuarioPerfil.setUsuario(usuario);
        usuarioPerfil.setDataCadastro(new Date());
        usuarioPerfil.setPerfil(new Perfil(perfilId));
        usuarioPerfil.setAtivo(true);
        usuarioPerfilRepository.save(usuarioPerfil);
    }
}

package com.akira.apihemomar.services;


import com.akira.apihemomar.dto.request.UsuarioReqDto;
import com.akira.apihemomar.dto.response.UsuarioRespDto;
import com.akira.apihemomar.models.Usuario;
import com.akira.apihemomar.repository.UsuarioRepository;
import com.akira.apihemomar.util.Criptografia;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<UsuarioRespDto> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::converterUsuarioEmDto)
                .collect(Collectors.toList());
    }
    public Usuario buscarUsuarioId(Long id){
        //todo:substituir exception pela customizada
        return usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario não encontrado !"));
    }

    @Transactional
    public UsuarioRespDto cadastraUsuario(UsuarioReqDto usuarioReqDto) {
        validarCadastroUsuario(usuarioReqDto);
        Usuario usuario = converterDtoEmCadastroUsuario(usuarioReqDto);
        return converterUsuarioEmDto(usuarioRepository.save(usuario));

    }

    private UsuarioRespDto converterUsuarioEmDto(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioRespDto.class);
    }

    private Usuario converterDtoEmCadastroUsuario(UsuarioReqDto usuarioReqDto) {
        usuarioReqDto.UPPERCASE();
        Usuario usuario = modelMapper.map(usuarioReqDto, Usuario.class);
        usuario.setSenha(Criptografia.md5(usuarioReqDto.getSenha()));
        usuario.setDataCadastro(new Date());
        usuario.setBloqueado(false);
        usuario.setFatorRH(usuarioReqDto.getFatorRH().name());
        usuario.setTipoSanguineo(usuarioReqDto.getTipoSanguineo().name());
        return usuario;
    }

    private void validarCadastroUsuario(UsuarioReqDto usuarioReqDto) {
        //todo:mudar para exception customizada
        Optional<Usuario>  usuarioEmail=usuarioRepository.findByEmailIgnoreCase(usuarioReqDto.getEmail());
        if(usuarioEmail.isPresent()){
           throw new RuntimeException("Já existe um usuario com este E-mail !");
        }
        Optional<Usuario>  usuarioCpf=usuarioRepository.findByCpf(usuarioReqDto.getCpf());
        if(usuarioCpf.isPresent()){
            throw new RuntimeException("Já existe um usuario com este CPF !");
        }

    }
}

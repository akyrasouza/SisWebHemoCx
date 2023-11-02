package com.akira.apihemomar.services;


import com.akira.apihemomar.dto.request.LoginReqDto;
import com.akira.apihemomar.dto.request.UsuarioReqDto;
import com.akira.apihemomar.dto.response.LoginUsuarioRespDto;
import com.akira.apihemomar.dto.response.UsuarioRespDto;
import com.akira.apihemomar.exception.ConflitoException;
import com.akira.apihemomar.exception.NotFoundException;
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
    private EnderecoService enderecoService;
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
        return usuarioRepository.findById(id).orElseThrow(()->new NotFoundException("Usuario não encontrado !"));
    }

    @Transactional
    public UsuarioRespDto cadastraUsuario(UsuarioReqDto usuarioReqDto) {
        validarCadastroUsuario(usuarioReqDto);
        Usuario usuario = converterDtoEmCadastroUsuario(usuarioReqDto);
        usuario.setLogin(usuarioReqDto.getEmail());
        usuario=usuarioRepository.save(usuario);
        enderecoService.cadastrarEndereco(usuario.getId(),usuarioReqDto);
        return converterUsuarioEmDto(usuario);

    }
    public LoginUsuarioRespDto loginUsuario(LoginReqDto loginReqDto) {
        Usuario usuario=usuarioRepository.findByLogin(loginReqDto.getUsuario())
                .orElseThrow(()->new NotFoundException("Login  não encontrado!"));
        if(!usuario.getSenha().equals(Criptografia.md5(loginReqDto.getSenha()))){
            throw new NotFoundException("Login  não encontrado!");
        }
        return converterUsuarioEmDtoLogin(usuario);
    }

    private UsuarioRespDto converterUsuarioEmDto(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioRespDto.class);
    }
    private LoginUsuarioRespDto converterUsuarioEmDtoLogin(Usuario usuario) {
        LoginUsuarioRespDto loginDto = modelMapper.map(usuario, LoginUsuarioRespDto.class);
        loginDto.getItensMenu().add("informacoes");
        loginDto.getItensMenu().add("doacao");
        loginDto.getItensMenu().add("dashboard");
        loginDto.getItensMenu().add("configuracoes");
        return loginDto;
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
           throw new ConflitoException("Já existe um usuario com este E-mail !");
        }
        Optional<Usuario>  usuarioCpf=usuarioRepository.findByCpf(usuarioReqDto.getCpf());
        if(usuarioCpf.isPresent()){
            throw new ConflitoException("Já existe um usuario com este CPF !");
        }

    }


}

package com.akira.apihemomar.services;


import com.akira.apihemomar.dto.request.LoginReqDto;
import com.akira.apihemomar.dto.request.UsuarioReqDto;
import com.akira.apihemomar.dto.response.LoginUsuarioRespDto;
import com.akira.apihemomar.dto.response.UsuarioRespDto;
import com.akira.apihemomar.enums.PERFIL;
import com.akira.apihemomar.exception.ConflitoException;
import com.akira.apihemomar.exception.NotFoundException;
import com.akira.apihemomar.models.ModuloPerfil;
import com.akira.apihemomar.models.Usuario;
import com.akira.apihemomar.repository.UsuarioRepository;
import com.akira.apihemomar.util.Criptografia;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final  EnderecoService enderecoService;
    private final  ModelMapper modelMapper;
    private  final UsuarioPerfilService  usuarioPerfilService;
    private  final ModuloPerfilService moduloPerfilService;
    public UsuarioService(UsuarioRepository usuarioRepository, EnderecoService enderecoService, ModelMapper modelMapper, UsuarioPerfilService usuarioPerfilService, ModuloPerfilService moduloPerfilService) {
        this.usuarioRepository = usuarioRepository;
        this.enderecoService = enderecoService;
        this.modelMapper = modelMapper;
        this.usuarioPerfilService = usuarioPerfilService;
        this.moduloPerfilService = moduloPerfilService;
    }

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
        cadastrarPerfilUsuario(usuario, PERFIL.USER);
        return converterUsuarioEmDto(usuario);

    }

    private void cadastrarPerfilUsuario(Usuario usuario, PERFIL user) {
        usuarioPerfilService.cadastrarPerfilUsuario(usuario,user.getId());
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
        loginDto.getItensMenu().addAll(buscarModulos(usuario.getId()));
        return loginDto;
    }
    private List<String> buscarModulos(Long usuarioId){
        List<ModuloPerfil> moduloPerfils = moduloPerfilService.buscarModulosPerfilUsuario(usuarioId);
        if(moduloPerfils.isEmpty()){throw new NotFoundException("O usuário não possui opções de menu");}
        return moduloPerfils
                .stream()
                .sorted(Comparator.comparing(mp->mp.getModulo().getId()))
                .map(moduloPerfil->moduloPerfil.getModulo().getDescricao())
                .collect(Collectors.toList());
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

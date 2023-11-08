package com.akira.apihemomar.services;


import com.akira.apihemomar.dto.request.UsuarioReqDto;
import com.akira.apihemomar.dto.response.EnderecoRespDto;
import com.akira.apihemomar.models.Endereco;
import com.akira.apihemomar.models.Usuario;
import com.akira.apihemomar.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {


    private final ModelMapper modelMapper;

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(ModelMapper modelMapper, EnderecoRepository enderecoRepository) {
        this.modelMapper = modelMapper;
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional
    public void cadastrarEndereco(Usuario usuario, UsuarioReqDto usuarioReqDto) {
        Endereco endereco = converterDtoEmEndereco(usuario, usuarioReqDto);
        enderecoRepository.save(endereco);
    }

    public List<EnderecoRespDto> findAll() {
        return enderecoRepository.findAll()
                .stream()
                .map(this::converterEnderecoEmDto)
                .collect(Collectors.toList());

    }

    private EnderecoRespDto converterEnderecoEmDto(Endereco endereco) {
        return modelMapper.map(endereco, EnderecoRespDto.class);
    }


    private Endereco converterDtoEmEndereco(Usuario usuario, UsuarioReqDto usuarioReqDto) {
        Endereco endereco = modelMapper.map(usuarioReqDto, Endereco.class);
        endereco.setAtivo(true);
        endereco.setDataCadastro(new Date());
        endereco.setUsuario(usuario);
        return endereco;
    }

}

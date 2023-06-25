package com.akira.apihemomar.services;


import com.akira.apihemomar.dto.request.EnderecoReqDto;
import com.akira.apihemomar.dto.response.EnderecoRespDto;
import com.akira.apihemomar.models.Endereco;
import com.akira.apihemomar.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EnderecoRepository  enderecoRepository;

    @Autowired
    private UsuarioService  usuarioService;

    @Transactional
    public void cadastrarEndereco(EnderecoReqDto enderecoReqDto){
       Endereco endereco =converterDtoEmEndereco(enderecoReqDto);
        enderecoRepository.save(endereco);
    }
    public List<EnderecoRespDto> findAll() {
        return enderecoRepository.findAll()
                .stream()
                .map(this::converterEnderecoEmDto)
                .collect(Collectors.toList());

    }
    private EnderecoRespDto  converterEnderecoEmDto(Endereco endereco) {
        return  modelMapper.map(endereco,EnderecoRespDto.class);
    }


    private  Endereco converterDtoEmEndereco(EnderecoReqDto enderecoReqDto) {
        enderecoReqDto.UPPERCASE();
        Endereco endereco=modelMapper.map(enderecoReqDto,Endereco.class);
        endereco.setAtivo(true);
        endereco.setDataCadastro(new Date());
        endereco.setUsuario(usuarioService.buscarUsuarioId(enderecoReqDto.getUsuario()));
        return endereco;
    }

}

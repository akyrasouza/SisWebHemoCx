package com.akira.apihemomar.services;



import com.akira.apihemomar.dto.response.StatusRespDto;
import com.akira.apihemomar.models.StatusDoacao;
import com.akira.apihemomar.repository.StatusDoacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusDoacaoService {
    private final StatusDoacaoRepository  statusDoacaoRepository;
    private  final ModelMapper   modelMapper;
    public StatusDoacaoService(StatusDoacaoRepository statusDoacaoRepository, ModelMapper modelMapper) {
        this.statusDoacaoRepository = statusDoacaoRepository;
        this.modelMapper = modelMapper;
    }

    public StatusDoacao buscarStatusDocaoId(Long id){
        //todo:substituir exception pela customizada
        return statusDoacaoRepository.findById(id).orElseThrow(()->new RuntimeException("Status doação não encontrado !"));
    }
    public List<StatusRespDto> buscarTodosStatus(){
        return  statusDoacaoRepository.findAll()
                .stream()
                .map(statusDoacao -> modelMapper.map(statusDoacao, StatusRespDto.class))
                .collect(Collectors.toList());
    }

}

package com.akira.apihemomar.services;


import com.akira.apihemomar.dto.response.HorarioRespDto;
import com.akira.apihemomar.enums.SIGLA;
import com.akira.apihemomar.exception.NotFoundException;
import com.akira.apihemomar.models.Horario;
import com.akira.apihemomar.repository.HorarioRepository;
import com.akira.apihemomar.util.DataUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository  horarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Horario buscarHorarioId(Long id){
        //todo:substituir exception pela customizada
        return horarioRepository.findById(id).orElseThrow(()->new RuntimeException("Horário  não encontrado !"));
    }
    public List<HorarioRespDto> buscarHorariosPeloDiaSemana(SIGLA sigla){

        return horarioRepository.buscarHorariosPeloDiaSemana(sigla.name())
                .stream()
                .map(this::converterHorarioEmDto)
                .collect(Collectors.toList());

    }
    public List<HorarioRespDto> buscarHorarioPeloDia(Date data){
       Integer inciceSemana= DataUtil.getIndiceData(data);
        return horarioRepository.buscarHorariosPeloDia(inciceSemana)
                .stream()
                .map(this::converterHorarioEmDto)
                .collect(Collectors.toList());

    }
    public  HorarioRespDto converterHorarioEmDto(Horario  horario){
        return modelMapper.map(horario,HorarioRespDto.class);
    }
}

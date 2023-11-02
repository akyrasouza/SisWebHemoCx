package com.akira.apihemomar.services;


import com.akira.apihemomar.dto.response.DashboardRespDto;
import com.akira.apihemomar.models.HistoricoDoacao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {
    private final HistoricoDoacaoService historicoDoacaoService;
    private  final ModelMapper  modelMapper;
    public DashboardService(HistoricoDoacaoService historicoDoacaoService, ModelMapper modelMapper) {
        this.historicoDoacaoService = historicoDoacaoService;
        this.modelMapper = modelMapper;
    }
    public List<DashboardRespDto>  buscarDoacoesAgendadas(){
       return historicoDoacaoService.buscarDoacoesAgendadas()
               .stream()
               .map(this::converterParaDashBoardDto).collect(Collectors.toList());
    }
    private DashboardRespDto converterParaDashBoardDto(HistoricoDoacao  historicoDoacao){
      return modelMapper.map(historicoDoacao, DashboardRespDto.class);
    }
}

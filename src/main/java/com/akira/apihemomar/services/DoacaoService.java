package com.akira.apihemomar.services;


import com.akira.apihemomar.dto.request.DoacaoReqDto;
import com.akira.apihemomar.models.Doacao;
import com.akira.apihemomar.models.HistoricoDoacao;
import com.akira.apihemomar.repository.DoacaoRepository;
import com.akira.apihemomar.util.DataUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Objects;

@Service
public class DoacaoService {
    @Autowired
    private DoacaoRepository  doacaoRepository;    
    @Autowired
    private ModelMapper  modelMapper;

    @Autowired
    private UsuarioService  usuarioService;

    @Autowired
    private TipoDoacaoService  tipoDoacaoService;

    @Autowired
    private  HorarioService horarioService;

    @Autowired
    private HistoricoDoacaoService  historicoDoacaoService;
    @Transactional
    public void atualizarDoacao(Long doacaoId, Long status) {
     HistoricoDoacao historicoDoacao=historicoDoacaoService.buscarDoacaoAtiva(doacaoId);
     cadastarHistoricoDoacao(historicoDoacao.getDoacao(),status);
     historicoDoacaoService.desativarHistoricoDoacao(historicoDoacao);
    }
    @Transactional
    public void cadastrarDoacao(DoacaoReqDto  doacaoReqDto){
        //todo:analisar cadastro para o mesmo dia
        validarCadastroDoacao(doacaoReqDto);
        Doacao doacao=converterDtoEmDoacao(doacaoReqDto);
        doacao= doacaoRepository.save(doacao);
        cadastarHistoricoDoacao(doacao,1L);

    }

    private void cadastarHistoricoDoacao(Doacao doacao,Long status) {
        historicoDoacaoService.cadastrarHistoricoDoacao(doacao,status);
    }

    private Doacao converterDtoEmDoacao(DoacaoReqDto doacaoReqDto) {
        Doacao doacao=modelMapper.map(doacaoReqDto,Doacao.class);
        doacao.setUsuario(usuarioService.buscarUsuarioId(doacaoReqDto.getUsuario()));
        doacao.setTipoDoacao(tipoDoacaoService.buscarTipoDoacaoId(doacaoReqDto.getTipoDoacao()));
        doacao.setHorario(horarioService.buscarHorarioId(doacaoReqDto.getHorario()));
        return doacao;

    }


    private void validarCadastroDoacao(DoacaoReqDto doacaoReqDto) {
        //todo:trocar exception
        try {
           HistoricoDoacao historicoDoacao= historicoDoacaoService.buscarHistoricosData(doacaoReqDto.getDataDoacao(),doacaoReqDto.getUsuario());
           if(Objects.nonNull(historicoDoacao)){
               throw new RuntimeException("Data já cadastrada !");
           }
            if (DataUtil.dataPassado(doacaoReqDto.getDataDoacao())) {
                throw new RuntimeException("A data informada não pode ser anterior á data  atual !");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}

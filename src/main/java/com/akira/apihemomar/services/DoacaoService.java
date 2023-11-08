package com.akira.apihemomar.services;


import com.akira.apihemomar.dto.request.DoacaoReqDto;
import com.akira.apihemomar.exception.ConflitoException;
import com.akira.apihemomar.models.Doacao;
import com.akira.apihemomar.models.HistoricoDoacao;
import com.akira.apihemomar.repository.DoacaoRepository;
import com.akira.apihemomar.util.DataUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Objects;

@Service
public class DoacaoService {

    private final DoacaoRepository  doacaoRepository;

    private final ModelMapper  modelMapper;


    private final UsuarioService  usuarioService;


    private final TipoDoacaoService  tipoDoacaoService;


    private  final HorarioService horarioService;


    private HistoricoDoacaoService  historicoDoacaoService;

    public DoacaoService(DoacaoRepository doacaoRepository, ModelMapper modelMapper, UsuarioService usuarioService,
                         TipoDoacaoService tipoDoacaoService, HorarioService horarioService, HistoricoDoacaoService historicoDoacaoService) {
        this.doacaoRepository = doacaoRepository;
        this.modelMapper = modelMapper;
        this.usuarioService = usuarioService;
        this.tipoDoacaoService = tipoDoacaoService;
        this.horarioService = horarioService;
        this.historicoDoacaoService = historicoDoacaoService;
    }

    @Transactional
    public void atualizarDoacao(Long doacaoId, Long status) {
     HistoricoDoacao historicoDoacao=historicoDoacaoService.buscarDoacaoAtiva(doacaoId);
     cadastarHistoricoDoacao(historicoDoacao.getDoacao(),status);
     historicoDoacaoService.desativarHistoricoDoacao(historicoDoacao);
    }
    @Transactional
    public void cadastrarDoacao(DoacaoReqDto  doacaoReqDto){
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

        try {
           HistoricoDoacao historicoDoacao= historicoDoacaoService.buscarHistoricosData(doacaoReqDto.getDataDoacao(),doacaoReqDto.getUsuario());
           if(Objects.nonNull(historicoDoacao)){
               throw new ConflitoException("Data já cadastrada !");
           }
            if (DataUtil.dataPassado(doacaoReqDto.getDataDoacao())) {
                throw new ConflitoException("A data informada não pode ser anterior á data  atual !");
            }
        } catch (ParseException e) {
            throw new ConflitoException("Conflito de formatação de data!");
        }
    }


}

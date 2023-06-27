package com.akira.apihemomar.services;


import com.akira.apihemomar.models.Doacao;
import com.akira.apihemomar.models.HistoricoDoacao;
import com.akira.apihemomar.models.StatusDoacao;
import com.akira.apihemomar.repository.HistoricoDoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class HistoricoDoacaoService {

    @Autowired
    private HistoricoDoacaoRepository  historicoDoacaoRepository;

    @Transactional
    public void cadastrarHistoricoDoacao(Doacao  doacao){
        HistoricoDoacao historicoDoacao=new HistoricoDoacao();
        historicoDoacao.setDoacao(doacao);
        historicoDoacao.setAtivo(true);
        historicoDoacao.setDataCadastro(new Date());
        historicoDoacao.setStatusDoacao(new StatusDoacao(1L));
        historicoDoacaoRepository.save(historicoDoacao);
    }

    public HistoricoDoacao buscarHistoricosData(Date data, Long usuarioId){
       return historicoDoacaoRepository.buscarHistoricosData(data,usuarioId);
    }
}

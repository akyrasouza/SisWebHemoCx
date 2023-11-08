package com.akira.apihemomar.services;


import com.akira.apihemomar.enums.SIGLA;
import com.akira.apihemomar.models.Doacao;
import com.akira.apihemomar.models.HistoricoDoacao;
import com.akira.apihemomar.models.StatusDoacao;
import com.akira.apihemomar.repository.HistoricoDoacaoRepository;
import com.akira.apihemomar.repository.spec.HistoricoDoacaoSpec;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class HistoricoDoacaoService {


    private final HistoricoDoacaoRepository  historicoDoacaoRepository;

    public HistoricoDoacaoService(HistoricoDoacaoRepository historicoDoacaoRepository) {
        this.historicoDoacaoRepository = historicoDoacaoRepository;
    }

    @Transactional
    public void cadastrarHistoricoDoacao(Doacao  doacao,Long status){
        HistoricoDoacao historicoDoacao=new HistoricoDoacao();
        historicoDoacao.setDoacao(doacao);
        historicoDoacao.setAtivo(true);
        historicoDoacao.setDataCadastro(new Date());
        historicoDoacao.setStatusDoacao(new StatusDoacao(status));
        historicoDoacaoRepository.save(historicoDoacao);
    }
    @Transactional
    public void desativarHistoricoDoacao(HistoricoDoacao historicoDoacao){
        historicoDoacao.setAtivo(false);
        historicoDoacaoRepository.save(historicoDoacao);
    }
    public HistoricoDoacao buscarDoacaoAtiva(Long doacao){
        return  historicoDoacaoRepository.buscarDoacaoAtiva(doacao);
    }

    public HistoricoDoacao buscarHistoricosData(Date data, Long usuarioId){
       return historicoDoacaoRepository.buscarHistoricosData(data,usuarioId);
    }
    public List<HistoricoDoacao> buscarDoacoesAgendadas(Date dataInicio, Date  dataFim, String nome, SIGLA dia, String hora){
       return historicoDoacaoRepository.findAll(
                HistoricoDoacaoSpec.comAtivoHistoricoDoacao()
               .and(HistoricoDoacaoSpec.comHoraHistoricoDoacao(hora))
               .and(HistoricoDoacaoSpec.comDiaHistoricoDoacao(dia))
               .and(HistoricoDoacaoSpec.comNomeHistoricoDoacao(nome))
               .and(HistoricoDoacaoSpec.comdataIniciodataFimHistoricoDoacao(dataInicio,dataFim))
       );
    }
    public List<HistoricoDoacao> buscarDoacoesAgendadas(Long usuarioId){
        return historicoDoacaoRepository.findAll(
                HistoricoDoacaoSpec.comAtivoHistoricoDoacao()
                        .and(HistoricoDoacaoSpec.comUsuarioHistoricoDoacao(usuarioId))

        );
    }

}

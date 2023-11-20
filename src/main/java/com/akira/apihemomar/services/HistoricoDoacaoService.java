package com.akira.apihemomar.services;


import com.akira.apihemomar.enums.EMAIL;
import com.akira.apihemomar.enums.SIGLA;
import com.akira.apihemomar.models.Doacao;
import com.akira.apihemomar.models.HistoricoDoacao;
import com.akira.apihemomar.models.StatusDoacao;
import com.akira.apihemomar.repository.HistoricoDoacaoRepository;
import com.akira.apihemomar.repository.spec.HistoricoDoacaoSpec;
import com.akira.apihemomar.template.TemplateEmail;
import com.akira.apihemomar.util.DataUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class HistoricoDoacaoService {


    private final HistoricoDoacaoRepository  historicoDoacaoRepository;
    private  final EnvioEmailUsuario envioEmailUsuario;
    private  final StatusDoacaoService  statusDoacaoService;

    public HistoricoDoacaoService(HistoricoDoacaoRepository historicoDoacaoRepository, EnvioEmailUsuario envioEmailUsuario, StatusDoacaoService statusDoacaoService) {
        this.historicoDoacaoRepository = historicoDoacaoRepository;
        this.envioEmailUsuario = envioEmailUsuario;
        this.statusDoacaoService = statusDoacaoService;
    }

    @Transactional
    public void cadastrarHistoricoDoacao(Doacao  doacao,Long status){
        HistoricoDoacao historicoDoacao=new HistoricoDoacao();
        historicoDoacao.setDoacao(doacao);
        historicoDoacao.setAtivo(true);
        historicoDoacao.setDataCadastro(new Date());
        historicoDoacao.setStatusDoacao(new StatusDoacao(status));
        historicoDoacaoRepository.save(historicoDoacao);
        StatusDoacao statusDoacao=statusDoacaoService.buscarStatusDocaoId(status);
        String conteudo = "Olá "+doacao.getUsuario().getNome()+", o seu agendamento para a data "+ DataUtil.formatarData(doacao.getDataDoacao())+" em um dia de "+doacao.getHorario().getIndiceSemana().getDia()+" ás "+doacao.getHorario().getHora()+
                " está com o status: "+statusDoacao.getDescricao();
        envioEmailUsuario.envioEmail(doacao.getUsuario().getEmail(), EMAIL.TITULOSTATUS, TemplateEmail.templateAlteracaoStatus(conteudo));
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

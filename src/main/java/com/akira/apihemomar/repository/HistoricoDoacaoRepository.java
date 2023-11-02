package com.akira.apihemomar.repository;

import com.akira.apihemomar.models.HistoricoDoacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HistoricoDoacaoRepository extends JpaRepository<HistoricoDoacao,Long> {

    @Query(value = "select h from HistoricoDoacao h\n" +
            "join Doacao d on h.doacao.id =d.id and d.usuario.id=:usuario\n" +
            "and h.ativo =true\n" +
            "and d.dataDoacao =:dataDoacao\n" +
            "and h.statusDoacao.id<> 3\n"+
            "and h.statusDoacao.id<> 5\n"+
            "and h.statusDoacao.id<> 6\n")
    HistoricoDoacao buscarHistoricosData(Date dataDoacao,Long usuario);

    @Query(value = "select  hd.* from tb05_historico_doacao hd where hd.fktb05tb03_cod_doacao = :doacao and hd.tb05_ativo ",nativeQuery = true)
    HistoricoDoacao buscarDoacaoAtiva(Long doacao);

    List<HistoricoDoacao> findAllByAtivoIsTrue();
}

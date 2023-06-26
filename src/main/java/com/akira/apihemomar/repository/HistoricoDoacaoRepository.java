package com.akira.apihemomar.repository;

import com.akira.apihemomar.models.HistoricoDoacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoDoacaoRepository extends JpaRepository<HistoricoDoacao,Long> {
}

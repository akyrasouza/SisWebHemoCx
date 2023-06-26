package com.akira.apihemomar.repository;

import com.akira.apihemomar.models.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao,Long> {
}

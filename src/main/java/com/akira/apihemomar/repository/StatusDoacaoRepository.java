package com.akira.apihemomar.repository;

import com.akira.apihemomar.models.StatusDoacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDoacaoRepository extends JpaRepository<StatusDoacao,Long> {
}

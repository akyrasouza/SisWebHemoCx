package com.akira.apihemomar.repository;

import com.akira.apihemomar.models.TipoDoacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocaoRepository extends JpaRepository<TipoDoacao,Long> {
}

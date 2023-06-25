package com.akira.apihemomar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndiceSemanaRepository extends JpaRepository<com.akira.apihemomar.models.IndiceSemana,Integer> {
}

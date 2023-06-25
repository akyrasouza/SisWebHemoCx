package com.akira.apihemomar.repository;

import com.akira.apihemomar.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Long> {
    @Query(value = "select h from Horario h  where h.indiceSemana.id =:indice")
    List<Horario> buscarHorariosPeloDia(Integer indice);
}

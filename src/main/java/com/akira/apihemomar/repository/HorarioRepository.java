package com.akira.apihemomar.repository;

import com.akira.apihemomar.enums.SIGLA;
import com.akira.apihemomar.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Long> {
    @Query(value = "select h from Horario h  where h.indiceSemana.id =:indice")
    List<Horario> buscarHorariosPeloDia(Integer indice);
    @Query(value = "select h.* from tb11_horario h\n" +
            "join tb12_indice_semana indice on h.fktb11tb12_cod_indice_semana =indice.tb12_cod_indice_semana\n" +
            "and indice.tb12_sigla =:sigla",nativeQuery = true)
    List<Horario> buscarHorariosPeloDiaSemana(String sigla);
}

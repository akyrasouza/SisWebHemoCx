package com.akira.apihemomar.repository.spec;

import com.akira.apihemomar.enums.SIGLA;
import com.akira.apihemomar.models.HistoricoDoacao;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.Objects;

public class HistoricoDoacaoSpec {
    public static Specification<HistoricoDoacao> comAtivoHistoricoDoacao() {
        return (root, query, builder) -> {
            return builder.equal(root.get("ativo"),true);
        };
    }
    public static Specification<HistoricoDoacao> comDiaHistoricoDoacao(SIGLA dia) {
        return (root, query, builder) -> {
            if (Objects.isNull(dia)) {
                return builder.conjunction();
            }
            return builder.equal(root.get("doacao").get("horario").get("indiceSemana").get("sigla"),dia.name());
        };
    }
    public static Specification<HistoricoDoacao> comHoraHistoricoDoacao(String hora) {
        return (root, query, builder) -> {
            if (Objects.isNull(hora)) {
                return builder.conjunction();
            }
            return builder.equal(root.get("doacao").get("horario").get("hora"),hora);
        };
    }
    public static Specification<HistoricoDoacao> comUsuarioHistoricoDoacao(Long usuarioId) {
        return (root, query, builder) -> {
            if (Objects.isNull(usuarioId)) {
                return builder.conjunction();
            }
            return builder.equal(root.get("doacao").get("usuario").get("id"),usuarioId);
        };
    }
    public static Specification<HistoricoDoacao> comNomeHistoricoDoacao(String nome) {
        return (root, query, builder) -> {
            if (Objects.isNull(nome)) {
                return builder.conjunction();
            }
            return builder.like(builder.upper(root.get("doacao").get("usuario").get("nome")), "%" + nome.toUpperCase().trim() + "%");
        };
    }
    public static Specification<HistoricoDoacao> comdataIniciodataFimHistoricoDoacao(Date dataInicio, Date dataFim) {
        return (root, query, builder) -> {
            if (Objects.isNull(dataInicio) && Objects.isNull(dataFim)) {
                return builder.conjunction();
            }
            if (Objects.nonNull(dataInicio) && Objects.isNull(dataFim)) {
                return builder.greaterThanOrEqualTo(root.get("doacao").get("dataDoacao"), dataInicio);
            }
            if (Objects.isNull(dataInicio) && Objects.nonNull(dataFim)) {
                return builder.lessThanOrEqualTo(root.get("doacao").get("dataDoacao"), dataFim);
            }
            return builder.and(
                    builder.greaterThanOrEqualTo(root.get("doacao").get("dataDoacao"), dataInicio),
                    builder.lessThanOrEqualTo(root.get("doacao").get("dataDoacao"), dataFim)
            );
        };
    }

}

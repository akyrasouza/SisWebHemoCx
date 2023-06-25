package com.akira.apihemomar.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HorarioRespDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String hora;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dia")
    private String indiceSemanaDia;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("sigla")
    private String indiceSemanaSigla;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getIndiceSemanaDia() {
        return indiceSemanaDia;
    }

    public void setIndiceSemanaDia(String indiceSemanaDia) {
        this.indiceSemanaDia = indiceSemanaDia;
    }

    public String getIndiceSemanaSigla() {
        return indiceSemanaSigla;
    }

    public void setIndiceSemanaSigla(String indiceSemanaSigla) {
        this.indiceSemanaSigla = indiceSemanaSigla;
    }
}

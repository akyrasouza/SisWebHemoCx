package com.akira.apihemomar.dto.request;

import com.akira.apihemomar.annotation.DateCustom;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DoacaoReqDto {
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    @NotNull(message = "A  data de doação não pode vazia ou nula!")
    @DateCustom
    private String dataDoacao;
    private String observacao;
    @NotNull(message = "O usuario não pode vazio ou nulo!")
    private Long usuario;
    @NotNull(message = "O tipo  de doação não pode vazio ou nulo!")
    private Long tipoDoacao;
    @NotNull(message = "O horário de doação não pode vazio ou nulo!")
    private Long horario;

    public Date getDataDoacao() throws ParseException {
        return formatter.parse(this.dataDoacao);
    }

    public void setDataDoacao(String dataDoacao) {

        this.dataDoacao = dataDoacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getTipoDoacao() {
        return tipoDoacao;
    }

    public void setTipoDoacao(Long tipoDoacao) {
        this.tipoDoacao = tipoDoacao;
    }

    public Long getHorario() {
        return horario;
    }

    public void setHorario(Long horario) {
        this.horario = horario;
    }
    public void UPPERCASE(){
        this.observacao= Objects.isNull(this.observacao)?this.observacao:this.observacao.toUpperCase();
    }
}

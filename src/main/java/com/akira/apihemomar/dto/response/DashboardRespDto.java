package com.akira.apihemomar.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class DashboardRespDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean ativo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dataDoacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date doacaoDataDoacao;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  Long doacaoId;
    @JsonProperty("usuarioId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  Long doacaoUsuarioId;
    @JsonProperty("usuarioNome")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  String doacaoUsuarioNome;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  Long tipoDoacaoId;
    @JsonProperty("tipoDoacao")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  String tipoDoacaoDescricao;
    @JsonProperty("hora")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String doacaoHorarioHora;
    @JsonProperty("diaSemana")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  String doacaoHorarioIndiceSemanaDia;
    @JsonProperty("observacao")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  String doacaoObservacao;
    @JsonProperty("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  String statusDoacaoDescricao;
    @JsonProperty("statusId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  Long statusDoacaoId;

    public Long getDoacaoId() {
        return doacaoId;
    }

    public void setDoacaoId(Long doacaoId) {
        this.doacaoId = doacaoId;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Long getDoacaoUsuarioId() {
        return doacaoUsuarioId;
    }

    public void setDoacaoUsuarioId(Long doacaoUsuarioId) {
        this.doacaoUsuarioId = doacaoUsuarioId;
    }

    public String getDoacaoUsuarioNome() {
        return doacaoUsuarioNome;
    }

    public void setDoacaoUsuarioNome(String doacaoUsuarioNome) {
        this.doacaoUsuarioNome = doacaoUsuarioNome;
    }

    public Long getTipoDoacaoId() {
        return tipoDoacaoId;
    }

    public void setTipoDoacaoId(Long tipoDoacaoId) {
        this.tipoDoacaoId = tipoDoacaoId;
    }

    public String getTipoDoacaoDescricao() {
        return tipoDoacaoDescricao;
    }

    public void setTipoDoacaoDescricao(String tipoDoacaoDescricao) {
        this.tipoDoacaoDescricao = tipoDoacaoDescricao;
    }

    public String getDoacaoHorarioHora() {
        return doacaoHorarioHora;
    }

    public void setDoacaoHorarioHora(String doacaoHorarioHora) {
        this.doacaoHorarioHora = doacaoHorarioHora;
    }

    public String getDoacaoHorarioIndiceSemanaDia() {
        return doacaoHorarioIndiceSemanaDia;
    }

    public void setDoacaoHorarioIndiceSemanaDia(String doacaoHorarioIndiceSemanaDia) {
        this.doacaoHorarioIndiceSemanaDia = doacaoHorarioIndiceSemanaDia;
    }

    public String getDoacaoObservacao() {
        return doacaoObservacao;
    }

    public void setDoacaoObservacao(String doacaoObservacao) {
        this.doacaoObservacao = doacaoObservacao;
    }

    public String getStatusDoacaoDescricao() {
        return statusDoacaoDescricao;
    }

    public void setStatusDoacaoDescricao(String statusDoacaoDescricao) {
        this.statusDoacaoDescricao = statusDoacaoDescricao;
    }

    public Long getStatusDoacaoId() {
        return statusDoacaoId;
    }

    public void setStatusDoacaoId(Long statusDoacaoId) {
        this.statusDoacaoId = statusDoacaoId;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDoacaoDataDoacao() {
        return doacaoDataDoacao;
    }

    public void setDoacaoDataDoacao(Date doacaoDataDoacao) {
        this.doacaoDataDoacao = doacaoDataDoacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

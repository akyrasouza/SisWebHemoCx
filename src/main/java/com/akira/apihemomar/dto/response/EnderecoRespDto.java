package com.akira.apihemomar.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

public class EnderecoRespDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cep;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String logradouro;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bairro;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String complemento;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numero;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean ativo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String localidade;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String uf;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long usuario;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }
}

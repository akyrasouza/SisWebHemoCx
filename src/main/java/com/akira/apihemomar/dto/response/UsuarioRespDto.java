package com.akira.apihemomar.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

public class UsuarioRespDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cpf;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String telefone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomePai;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeMae;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sexo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tipoSanguineo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fatorRH;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getFatorRH() {
        return fatorRH;
    }

    public void setFatorRH(String fatorRH) {
        this.fatorRH = fatorRH;
    }
}

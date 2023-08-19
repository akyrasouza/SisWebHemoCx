package com.akira.apihemomar.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class EnderecoReqDto {
    @NotBlank(message = "O Cep não pode ser vazio ou nulo !")
    @Size(max = 9, message = "O Cep deverá conter no máximo 9 caracteres !")
    private String cep;
    @NotBlank(message = "O Logradouro não pode ser vazio ou nulo !")
    @Size(max = 100, message = "O Logradouro deverá conter no máximo 100 caracteres !")
    private String logradouro;
    @NotBlank(message = "O Bairro não pode ser vazio ou nulo !")
    @Size(max = 100, message = "O Bairro deverá conter no máximo 100 caracteres !")
    private String bairro;
    @Size(max = 100, message = "O Complemento deverá conter no máximo 100 caracteres !")
    private String complemento;
    @Size(max = 8, message = "O Numero deverá conter no máximo 8 caracteres !")
    private String numero;
    @NotNull(message = "A localidade  pode ser vazia ou nula !")
    private String localidade;
    @NotBlank(message = "Uf não pode ser vazio ou nulo !")
    private String uf;

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

    public void UPPERCASE(){
        this.logradouro=this.logradouro.toUpperCase();
        this.bairro=this.bairro.toUpperCase();
        this.complemento= Objects.isNull(this.complemento)?this.complemento:this.complemento.toUpperCase();
        this.localidade=this.localidade.toUpperCase();
        this.uf=this.uf.toUpperCase();
    }
}

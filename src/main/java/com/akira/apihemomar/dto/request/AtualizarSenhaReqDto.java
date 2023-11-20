package com.akira.apihemomar.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AtualizarSenhaReqDto {
    @NotNull(message = "O E-mail não pode ser vazio ou nulo!")
    @Email(message = "E-mail inválido!")
    private String email;
    @NotBlank(message = "O código não pode ser vazio ou nulo!")
    private String codigo;
    @NotBlank(message = "A senha não pode ser vazia ou nula!")
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

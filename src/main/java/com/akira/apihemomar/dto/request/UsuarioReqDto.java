package com.akira.apihemomar.dto.request;

import com.akira.apihemomar.annotation.DateCustom;
import com.akira.apihemomar.enums.FATORRH;
import com.akira.apihemomar.enums.SEXO;
import com.akira.apihemomar.enums.TIPOSANGUINEO;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioReqDto {
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    @NotNull(message = "O login não pode vazio ou nulo!")
    @Size(max = 100,message = "O tamanho maximo do login permitido é 100 caracteres!")
    private String login;
    @NotNull(message = "O nome não pode vazio ou nulo!")
    @Size(max = 255,message = "O tamanho maximo do nome  permitido é 255 caracteres!")
    private String nome;
    @NotNull(message = "A  senha não pode vazia ou nula!")
    @Size(min =8,max = 16 ,message = "A  senha deverá ficar entre 8 e 16 caracteres!")
    private String senha;
    @CPF(message = "CPF inválido !")
    @NotNull(message = "O  CPF não pode vazio ou nulo!")
    private String cpf;
    @Email(message = "E-MAIL inválido !")
    @NotNull(message = "O  Email não pode vazio ou nulo!")
    private String email;
    @Size(max= 15,message = "O tamanho maximo da senha permitido é 15 caracteres!")
    private String telefone;
    @Size(max= 255,message = "O tamanho maximo do nome do pai permitido é 255 caracteres!")
    private String nomePai;
    @Size(max= 255,message = "O tamanho maximo do nome da mãe permitido é 255 caracteres!")
    private String nomeMae;
    @NotNull(message = "A  data de nascimento não pode vazia ou nula!")
    @DateCustom
    private String dataNascimento;
    @NotNull(message = "O sexo  não pode vazio ou nulo!")
    private SEXO sexo;
    @NotNull(message = "A  tipo sanguineo não pode vazio ou nulo!")
    private TIPOSANGUINEO tipoSanguineo;
    @NotNull(message = "O fator RH não pode vazio ou nulo!")
    private FATORRH fatorRH;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

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

    public Date getDataNascimento() throws ParseException {
        return formatter.parse(dataNascimento);
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public SEXO  getSexo() {
        return sexo;
    }

    public void setSexo(SEXO sexo) {
        this.sexo = sexo;
    }

    public TIPOSANGUINEO getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TIPOSANGUINEO tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public FATORRH getFatorRH() {
        return fatorRH;
    }

    public void setFatorRH(FATORRH fatorRH) {
        this.fatorRH = fatorRH;
    }
    public void UPCASE(){
        this.nome=this.nome.toUpperCase();
        this.nomePai=this.nomePai.toUpperCase();
        this.nomeMae=this.nomeMae.toUpperCase();
        this.email=this.email.toUpperCase();
        this.login=this.login.toUpperCase();

    }
}

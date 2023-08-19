package com.akira.apihemomar.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB01_USUARIO")
@SequenceGenerator(name = "TB01_USUARIO_TB01_COD_USUARIO_SEQ", sequenceName = "TB01_USUARIO_TB01_COD_USUARIO_SEQ",allocationSize = 1)
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB01_USUARIO_TB01_COD_USUARIO_SEQ")
    @Column(name = "TB01_COD_USUARIO")
    private Long id;
    @Column(name = "TB01_ID")
    private String login;
    @Column(name = "TB01_NOME")
    private String nome;
    @Column(name = "TB01_SENHA")
    private String senha;
    @Column(name = "TB01_DATA_CADASTRO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;
    @Column(name = "TB01_ULTIMO_ACESSO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date ultimoAcesso;
    @Column(name = "TB01_BLOQUEADO")
    private Boolean bloqueado;
    @Column(name = "TB01_DATA_BLOQUEIO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataBloqueio;
    @Column(name =  "TB01_CPF")
    private String cpf;
    @Column(name =  "TB01_EMAIL")
    private String email;
    @Column(name =  "TB01_TELEFONE")
    private String telefone;
    @Column(name =  "TB01_NOME_MAE")
    private String nomeMae;
    @Column(name = "TB01_DATA_NASCIMENTO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    @Column(name =  "TB01_SEXO")
    private String sexo;
    @Column(name = "TB01_TIPO_SANGUINEO")
    private String tipoSanguineo;
    @Column(name = "TB01_FATOR_RH")
    private  String fatorRH;

    public Usuario() {

    }

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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Date getDataBloqueio() {
        return dataBloqueio;
    }

    public void setDataBloqueio(Date dataBloqueio) {
        this.dataBloqueio = dataBloqueio;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(login, usuario.login) && Objects.equals(nome, usuario.nome) && Objects.equals(senha, usuario.senha) && Objects.equals(dataCadastro, usuario.dataCadastro) && Objects.equals(ultimoAcesso, usuario.ultimoAcesso) && Objects.equals(bloqueado, usuario.bloqueado) && Objects.equals(dataBloqueio, usuario.dataBloqueio) && Objects.equals(cpf, usuario.cpf) && Objects.equals(email, usuario.email) && Objects.equals(telefone, usuario.telefone) &&  Objects.equals(nomeMae, usuario.nomeMae) && Objects.equals(dataNascimento, usuario.dataNascimento) && Objects.equals(sexo, usuario.sexo) && Objects.equals(tipoSanguineo, usuario.tipoSanguineo) && Objects.equals(fatorRH, usuario.fatorRH);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, nome, senha, dataCadastro, ultimoAcesso, bloqueado, dataBloqueio, cpf, email, telefone, nomeMae, dataNascimento, sexo, tipoSanguineo, fatorRH);
    }
}
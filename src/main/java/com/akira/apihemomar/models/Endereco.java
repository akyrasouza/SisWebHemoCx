package com.akira.apihemomar.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB02_ENDERECO")
@SequenceGenerator(name = "TB02_ENDERECO_TB02_COD_ENDERECO_SEQ", sequenceName = "TB02_ENDERECO_TB02_COD_ENDERECO_SEQ", allocationSize = 1)
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB02_ENDERECO_TB02_COD_ENDERECO_SEQ")
    @Column(name = "TB02_COD_ENDERECO")
    private Long id;

    @Column(name = "TB02_CEP")
    private String cep;

    @Column(name = "TB02_LOGRADOURO")
    private String logradouro;

    @Column(name = "TB02_BAIRRO")
    private String bairro;

    @Column(name = "TB02_COMPLEMENTO")
    private String complemento;

    @Column(name = "TB02_NUMERO")
    private String numero;
    @Column(name = "TB02_LOCALIDADE")
    private String localidade;
    @Column(name = "TB02_UF")
    private String uf;
    @Column(name = "TB02_ATIVO")
    private Boolean ativo;
    @Column(name = "TB02_DATA_CADASTRO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;
    @ManyToOne
    @JoinColumn(name = "FKTB02TB01_COD_USUARIO")
    private Usuario usuario;

    public Endereco() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(cep, endereco.cep) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(bairro, endereco.bairro) && Objects.equals(complemento, endereco.complemento) && Objects.equals(numero, endereco.numero) && Objects.equals(localidade, endereco.localidade) && Objects.equals(uf, endereco.uf) && Objects.equals(ativo, endereco.ativo) && Objects.equals(dataCadastro, endereco.dataCadastro) && Objects.equals(usuario, endereco.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, logradouro, bairro, complemento, numero, localidade, uf, ativo, dataCadastro, usuario);
    }
}

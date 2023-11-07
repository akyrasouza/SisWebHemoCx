package com.akira.apihemomar.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB06_PERFIL")
@SequenceGenerator(name = "TB06_PERFIL_TB06_COD_PERFIL_SEQ", sequenceName = "TB06_PERFIL_TB06_COD_PERFIL_SEQ",allocationSize = 1)
public class Perfil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB06_PERFIL_TB06_COD_PERFIL_SEQ")
    @Column(name = "TB06_COD_PERFIL")
    private Long id;
    @Column(name = "TB06_NOME")
    private String  nome;
    @Column(name = "TB06_DESCRICAO")
    private String  descricao;
    @Column(name = "TB06_ATIVO")
    private Boolean  ativo;

    public Perfil(Long perfilId) {
        this.id=perfilId;
    }

    public Perfil() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return Objects.equals(id, perfil.id) && Objects.equals(nome, perfil.nome) && Objects.equals(descricao, perfil.descricao) && Objects.equals(ativo, perfil.ativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, ativo);
    }
}

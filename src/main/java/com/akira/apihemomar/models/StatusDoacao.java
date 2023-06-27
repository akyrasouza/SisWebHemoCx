package com.akira.apihemomar.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "TB04_STATUS_DOACAO")
@SequenceGenerator(name = "TB04_STATUS_DOACAO_TB04_COD_STATUS_DOACAO_SEQ", sequenceName = "TB04_STATUS_DOACAO_TB04_COD_STATUS_DOACAO_SEQ", allocationSize = 1)
public class StatusDoacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB04_STATUS_DOACAO_TB04_COD_STATUS_DOACAO_SEQ")
    @Column(name = "TB04_COD_STATUS_DOACAO")
    private Long id;
    @Column(name = "TB04_STATUS_DESCRICAO")
    private String descricao;
    @Column(name = "TB04_STATUS_ATIVO")
    private boolean ativo;
    public StatusDoacao() {
    }

    public StatusDoacao(Long id) {
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusDoacao that = (StatusDoacao) o;
        return ativo == that.ativo && Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, ativo);
    }
}

package com.akira.apihemomar.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB08_TIPO_SANGUINEO")
@SequenceGenerator(name = "TB08_TIPO_SANGUINEO_TB08_COD_TIPO_SANGUINEO_SEQ", sequenceName = "TB08_TIPO_SANGUINEO_TB08_COD_TIPO_SANGUINEO_SEQ",allocationSize = 1)
public class TipoSanguineo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB08_TIPO_SANGUINEO_TB08_COD_TIPO_SANGUINEO_SEQ")
    @Column(name = "TB08_COD_TIPO_SANGUINEO")
    private Long id;
    @Column(name = "TB08_DESCRICAO")
    private String  descricao;
    @Column(name = "TB08_OBSERVACAO")
    private String  observacao;
    @Column(name = "TB08_ATIVO")
    private Boolean ativo;
    public TipoSanguineo() {
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
        TipoSanguineo that = (TipoSanguineo) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(observacao, that.observacao) && Objects.equals(ativo, that.ativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, observacao, ativo);
    }
}

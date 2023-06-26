package com.akira.apihemomar.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB10_TIPO_DOACAO")
@SequenceGenerator(name = "TB10_TIPO_DOACAO_TB10_TIPO_DOACAO_SEQ", sequenceName = "TB10_TIPO_DOACAO_TB10_TIPO_DOACAO_SEQ", allocationSize = 1)
public class TipoDoacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB10_TIPO_DOACAO_TB10_TIPO_DOACAO_SEQ")
    @Column(name = "TB10_COD_TIPO_DOACAO")
    private Long id;

    @Column(name = "TB10_DESCRICAO")
    private String descricao;
    @Column(name = "TB10_ATIVO")
    private Boolean ativo;
    public TipoDoacao() {

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
        TipoDoacao that = (TipoDoacao) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(ativo, that.ativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, ativo);
    }
}

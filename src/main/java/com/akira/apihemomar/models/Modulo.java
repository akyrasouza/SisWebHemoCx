package com.akira.apihemomar.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB13_MODULO")
@SequenceGenerator(name = "TB13_MODULO_TB13_COD_MODULO_SEQ", sequenceName = "TB13_MODULO_TB13_COD_MODULO_SEQ", allocationSize = 1)
public class Modulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB13_MODULO_TB13_COD_MODULO_SEQ")
    @Column(name = "TB13_COD_MODULO")
    private Long id;
    @Column(name = "TB13_DESCRICAO")
    private String descricao;
    @Column(name = "TB13_ATIVO")
    private Boolean ativo;

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

    public Modulo() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modulo modulo = (Modulo) o;
        return Objects.equals(id, modulo.id) && Objects.equals(descricao, modulo.descricao) && Objects.equals(ativo, modulo.ativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, ativo);
    }
}

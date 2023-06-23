package com.akira.apihemomar.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB09_FATOR_RH")
@SequenceGenerator(name = "TB09_FATOR_RH_TB09_COD_FATOR_RH_SEQ", sequenceName = "TB09_FATOR_RH_TB09_COD_FATOR_RH_SEQ",allocationSize = 1)
public class FatorRH implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB09_FATOR_RH_TB09_COD_FATOR_RH_SEQ")
    @Column(name = "TB09_COD_FATOR_RH")
    private Long id;
    @Column(name = "TB09_DESCRICAO")
    private String  descricao;
    @Column(name = "TB09_ATIVO")
    private Boolean ativo;
    public FatorRH() {
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
        FatorRH fatorRH = (FatorRH) o;
        return Objects.equals(id, fatorRH.id) && Objects.equals(descricao, fatorRH.descricao) && Objects.equals(ativo, fatorRH.ativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, ativo);
    }
}

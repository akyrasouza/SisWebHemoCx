package com.akira.apihemomar.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB12_INDICE_SEMANA")
public class IndiceSemana implements Serializable {
    @Id
    @Column(name = "TB12_COD_INDICE_SEMANA")
    private Integer id;
    @Column(name = "TB12_DIA")
    private String dia;
    @Column(name =   "TB12_SIGLA")
    private String sigla;
    public IndiceSemana() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndiceSemana that = (IndiceSemana) o;
        return Objects.equals(id, that.id) && Objects.equals(dia, that.dia) && Objects.equals(sigla, that.sigla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dia, sigla);
    }
}

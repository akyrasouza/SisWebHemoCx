package com.akira.apihemomar.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB11_HORARIO")
@SequenceGenerator(name = "TB11_HORARIO_TB11_COD_HORARIO_SEQ", sequenceName = "TB11_HORARIO_TB11_COD_HORARIO_SEQ", allocationSize = 1)
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB11_HORARIO_TB11_COD_HORARIO_SEQ")
    @Column(name = "TB11_COD_HORARIO")
    private Long id;
    @Column(name = "TB11_HORA")
    private String hora;
    @ManyToOne
    @JoinColumn(name = "FKTB11TB12_COD_INDICE_SEMANA")
    private IndiceSemana indiceSemana;

    public Horario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public IndiceSemana getIndiceSemana() {
        return indiceSemana;
    }

    public void setIndiceSemana(IndiceSemana indiceSemana) {
        this.indiceSemana = indiceSemana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horario horario = (Horario) o;
        return Objects.equals(id, horario.id) && Objects.equals(hora, horario.hora) && Objects.equals(indiceSemana, horario.indiceSemana);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hora, indiceSemana);
    }
}

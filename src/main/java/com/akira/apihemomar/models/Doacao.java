package com.akira.apihemomar.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB03_DOACAO")
@SequenceGenerator(name = "TB03_DOACAO_TB03_COD_DOACAO_SEQ", sequenceName = "TB03_DOACAO_TB03_COD_DOACAO_SEQ", allocationSize = 1)
public class Doacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB03_DOACAO_TB03_COD_DOACAO_SEQ")
    @Column(name = "TB03_COD_DOACAO")
    private Long id;
    @Column(name = "TB03_DATA_DOACAO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDoacao;
    @Column(name = "TB03_OBSERVACAO")
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "FKTB03TB01_COD_USUARIO")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "FKTB03TB10_COD_TIPO_DOACAO")
    private TipoDoacao tipoDoacao;
    @ManyToOne
    @JoinColumn(name = "FKTB03TB11_COD_HORARIO")
    private Horario  horario;
    public Doacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoDoacao getTipoDoacao() {
        return tipoDoacao;
    }

    public void setTipoDoacao(TipoDoacao tipoDoacao) {
        this.tipoDoacao = tipoDoacao;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doacao doacao = (Doacao) o;
        return Objects.equals(id, doacao.id) && Objects.equals(dataDoacao, doacao.dataDoacao) && Objects.equals(observacao, doacao.observacao) && Objects.equals(usuario, doacao.usuario) && Objects.equals(tipoDoacao, doacao.tipoDoacao) && Objects.equals(horario, doacao.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataDoacao, observacao, usuario, tipoDoacao, horario);
    }
}














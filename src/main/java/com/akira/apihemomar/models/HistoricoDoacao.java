package com.akira.apihemomar.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "TB05_HISTORICO_DOACAO")
@SequenceGenerator(name = "TB05_HISTORICO_DOACAO_TB05_COD_HISTORICO_DOACAO_SEQ", sequenceName = "TB05_HISTORICO_DOACAO_TB05_COD_HISTORICO_DOACAO_SEQ", allocationSize = 1)
public class HistoricoDoacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB05_HISTORICO_DOACAO_TB05_COD_HISTORICO_DOACAO_SEQ")
    @Column(name = "TB05_COD_HISTORICO_DOACAO")
    private Long id;
    @Column(name = "TB05_DATA_CADASTRO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;
    @Column(name = "TB05_ATIVO")
    private Boolean ativo;
    @ManyToOne
    @JoinColumn(name = "FKTB05TB03_COD_DOACAO")
    private Doacao  doacao;
    @ManyToOne
    @JoinColumn(name = "FKTB05TB04_COD_STATUS_DOACAO")
    private StatusDoacao   statusDoacao;

    public HistoricoDoacao() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Doacao getDoacao() {
        return doacao;
    }

    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
    }

    public StatusDoacao getStatusDoacao() {
        return statusDoacao;
    }

    public void setStatusDoacao(StatusDoacao statusDoacao) {
        this.statusDoacao = statusDoacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoDoacao that = (HistoricoDoacao) o;
        return Objects.equals(id, that.id) && Objects.equals(dataCadastro, that.dataCadastro) && Objects.equals(ativo, that.ativo) && Objects.equals(doacao, that.doacao) && Objects.equals(statusDoacao, that.statusDoacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataCadastro, ativo, doacao, statusDoacao);
    }
}

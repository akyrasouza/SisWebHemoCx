package com.akira.apihemomar.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB07_USUARIO_PERFIL")
@SequenceGenerator(name = "TB07_USUARIO_PERFIL_TB07_COD_USUARIO_PERFIL_SEQ", sequenceName = "TB07_USUARIO_PERFIL_TB07_COD_USUARIO_PERFIL_SEQ",allocationSize = 1)
public class UsuarioPerfil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB07_USUARIO_PERFIL_TB07_COD_USUARIO_PERFIL_SEQ")
    @Column(name = "TB07_COD_USUARIO_PERFIL")
    private Long id;
    @Column(name = "TB07_DATA_CADASTRO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;
    @Column(name = "TB07_DATA_EXCLUSAO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataExclusao;
    @Column(name ="tb07_ativo")
    private Boolean ativo;
    @ManyToOne
    @JoinColumn(name = "FKTB07TB01_COD_USUARIO")
    private Usuario  usuario;
    @ManyToOne
    @JoinColumn(name = "FKTB07TB06_COD_PERFIL")
    private Perfil  perfil;

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

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioPerfil that = (UsuarioPerfil) o;
        return Objects.equals(id, that.id) && Objects.equals(dataCadastro, that.dataCadastro) && Objects.equals(dataExclusao, that.dataExclusao) && Objects.equals(ativo, that.ativo) && Objects.equals(usuario, that.usuario) && Objects.equals(perfil, that.perfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataCadastro, dataExclusao, ativo, usuario, perfil);
    }
}

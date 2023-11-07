package com.akira.apihemomar.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB14_MODULO_PERFIL")
@SequenceGenerator(name = "TB14_MODULO_PERFIL_TB14_COD_MODULO_PERFIL_SEQ", sequenceName = "TB14_MODULO_PERFIL_TB14_COD_MODULO_PERFIL_SEQ", allocationSize = 1)
public class ModuloPerfil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB14_MODULO_PERFIL_TB14_COD_MODULO_PERFIL_SEQ")
    @Column(name = "TB14_COD_MODULO_PERFIL")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "FKTB14TB07_COD_PERFIL")
    private Perfil perfil;
    @ManyToOne
    @JoinColumn(name = "FKTB14TB13_COD_MODULO")
    private Modulo modulo;
    @Column(name = "TB14_ATIVO")
    private Boolean ativo;

    public ModuloPerfil() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
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
        ModuloPerfil that = (ModuloPerfil) o;
        return Objects.equals(id, that.id) && Objects.equals(perfil, that.perfil) && Objects.equals(modulo, that.modulo) && Objects.equals(ativo, that.ativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, perfil, modulo, ativo);
    }
}

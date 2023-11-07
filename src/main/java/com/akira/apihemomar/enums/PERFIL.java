package com.akira.apihemomar.enums;

public enum PERFIL {
    ADMIN(1L),
    USER(2L);
    private Long id;

    public Long getId() {
        return id;
    }
    PERFIL(Long id) {
        this.id = id;
    }
}

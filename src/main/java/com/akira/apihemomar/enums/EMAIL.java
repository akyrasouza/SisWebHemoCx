package com.akira.apihemomar.enums;

public enum EMAIL {
    TITULORESETSENHA("Recuperação de senha Sistema HEMOMAR"),
    TITULOSTATUS("Descrição de Status de agendamento");
    private String value;

    public String getValue() {
        return value;
    }

    EMAIL(String value) {
        this.value = value;
    }
}

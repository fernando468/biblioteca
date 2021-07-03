package com.app.backend.event;

public enum Status {
    ABERTO("Aberto"),
    FINALIZADO("Finalizado");
    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

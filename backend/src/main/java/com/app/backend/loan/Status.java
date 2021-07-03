package com.app.backend.loan;

public enum Status {
    PENDENTE("Pendente"),
    FINALIZADO("Finalizado");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

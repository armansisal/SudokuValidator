package com.luxoft.career;

public enum Result {
    SUCCESS,
    DUPLICATE,
    MISSING,
    OUTBOUND,
    INVALID_INPUT;

    @Override
    public String toString() {
        return this.name();
    }
}

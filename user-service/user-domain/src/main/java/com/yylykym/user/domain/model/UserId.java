package com.yylykym.user.domain.model;

import java.util.UUID;

public record UserId(String value) {
    public UserId {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("UserId cannot be blank");
    }

    public static UserId newId() {
        return new UserId(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserId(String value1))) return false;
        return value.equals(value1);
    }

    @Override
    public String toString() {
        return value;
    }
}

package com.yylykym.user.domain.model;

import com.yylykym.user.domain.exception.InvalidEmailException;

import java.util.regex.Pattern;

public record Email(String value) {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public Email(String value) {
        if (value == null || value.isBlank()) throw new InvalidEmailException("Email cannot be blank");
        if (!EMAIL_PATTERN.matcher(value).matches())
            throw new InvalidEmailException("Invalid email: " + value);
        this.value = value.toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email(String value1))) return false;
        return value.equals(value1);
    }

    @Override
    public String toString() {
        return value;
    }
}

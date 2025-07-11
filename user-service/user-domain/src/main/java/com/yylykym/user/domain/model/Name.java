package com.yylykym.user.domain.model;


import com.yylykym.user.domain.exception.InvalidNameException;

public record Name(String value) {
    public Name {
        if (value == null || value.isBlank())
            throw new InvalidNameException("Name cannot be blank");
        if (value.length() > 50)
            throw new InvalidNameException("Name too long, max 50 chars");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name(String value1))) return false;
        return value.equals(value1);
    }

    @Override
    public String toString() {
        return value;
    }
}

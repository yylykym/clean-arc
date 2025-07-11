package com.yylykym.user.domain.model;


import com.yylykym.user.domain.exception.InvalidPasswordException;

public record PasswordHash(String value) {
    public PasswordHash {
        if (value == null || value.isBlank()) {
            throw new InvalidPasswordException("Password hash must not be empty");
        }
        // 可以加正则或长度校验
    }

    @Override
    public String toString() {
        return "******"; // 禁止输出真实密码hash
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PasswordHash(String value1))) return false;
        return value.equals(value1);
    }

}

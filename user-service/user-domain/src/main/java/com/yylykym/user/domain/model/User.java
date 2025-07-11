package com.yylykym.user.domain.model;

import java.util.Objects;

public class User {
    private final UserId id;
    private final Email email;
    private final Name name;
    private final PasswordHash password;

    public User(UserId id, Email email, Name name, PasswordHash password) {
        this.id = Objects.requireNonNull(id);
        this.email = Objects.requireNonNull(email);
        this.name = Objects.requireNonNull(name);
        this.password = Objects.requireNonNull(password);
    }

    public UserId getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    public PasswordHash getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", email=" + email + ", name=" + name + "}";
    }
}

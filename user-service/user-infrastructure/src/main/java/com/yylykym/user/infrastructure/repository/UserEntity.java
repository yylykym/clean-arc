package com.yylykym.user.infrastructure.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 18)
    private String passwordHash;

    protected UserEntity() {} // for JPA

    public UserEntity(String id, String email, String name, String passwordHash) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.passwordHash = passwordHash;
    }

    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getName() { return name; }

    public String getPasswordHash() {
        return passwordHash;
    }
}

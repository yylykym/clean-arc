package com.yylykym.user.infrastructure.repository;

import com.yylykym.user.domain.model.*;

public class UserEntityMapper {
    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;
        return new User(
                new UserId(entity.getId()),
                new Email(entity.getEmail()),
                new Name(entity.getName()),
                new PasswordHash(entity.getPasswordHash())
        );
    }

    public static UserEntity fromDomain(User user) {
        return new UserEntity(
                user.getId().value(),
                user.getEmail().value(),
                user.getName().value(),
                user.getPassword().value()
        );
    }
}

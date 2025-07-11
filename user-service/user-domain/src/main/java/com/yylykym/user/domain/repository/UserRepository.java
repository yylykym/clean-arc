package com.yylykym.user.domain.repository;

import com.yylykym.user.domain.model.Email;
import com.yylykym.user.domain.model.User;
import com.yylykym.user.domain.model.UserId;

import java.util.Optional;

public interface  UserRepository {
    Optional<User> findById(UserId id);

    Optional<User> findByEmail(Email email);

    void save(User user);

    boolean existsByEmail(Email email);
}

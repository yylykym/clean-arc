package com.yylykym.user.infrastructure.repository;

import com.yylykym.user.domain.model.Email;
import com.yylykym.user.domain.model.User;
import com.yylykym.user.domain.model.UserId;
import com.yylykym.user.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepository implements UserRepository {

    private final UserEntityRepository userEntityRepository;

    public JpaUserRepository(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Optional<User> findById(UserId id) {
        return userEntityRepository.findById(id.value())
                .map(UserEntityMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return userEntityRepository.findByEmail(email.value())
                .map(UserEntityMapper::toDomain);
    }

    @Override
    public void save(User user) {
        userEntityRepository.save(UserEntityMapper.fromDomain(user));
    }

    @Override
    public boolean existsByEmail(Email email) {
        return userEntityRepository.existsByEmail(email.value());
    }
}

package com.yylykym.user.application.usecase;

import com.yylykym.user.application.command.CreateUserCommand;
import com.yylykym.user.application.output.CreateUserOutput;
import com.yylykym.user.domain.exception.UserAlreadyExistsException;
import com.yylykym.user.domain.model.*;
import com.yylykym.user.domain.repository.UserRepository;

public class CreateUserUseCaseHandler implements CreateUserUseCase{
    private final UserRepository userRepository;

    // 构造注入
    public CreateUserUseCaseHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserOutput execute(CreateUserCommand command) {
        Email email = new Email(command.email());

        if (userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException("Email already registered: " + email);
        }

        User user = new User(UserId.newId(), email, new Name(command.name()), new PasswordHash(command.password()));
        userRepository.save(user);
        return new CreateUserOutput(user.getId());
    }
}

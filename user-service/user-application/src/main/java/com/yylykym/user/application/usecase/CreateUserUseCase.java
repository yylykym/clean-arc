package com.yylykym.user.application.usecase;

import com.yylykym.user.application.command.CreateUserCommand;
import com.yylykym.user.application.output.CreateUserOutput;

public interface CreateUserUseCase {
    CreateUserOutput execute(CreateUserCommand command);
}

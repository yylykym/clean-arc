package com.yylykym.user.application.output;

import com.yylykym.user.domain.model.UserId;

public record CreateUserOutput(String userId) {
    public CreateUserOutput(UserId userId) {
        this(userId.value());
    }
}

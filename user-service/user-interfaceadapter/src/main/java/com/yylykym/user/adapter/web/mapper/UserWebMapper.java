package com.yylykym.user.adapter.web.mapper;

import com.yylykym.user.adapter.web.response.CreateUserResponse;
import com.yylykym.user.adapter.web.request.CreateUserRequest;
import com.yylykym.user.application.command.CreateUserCommand;
import com.yylykym.user.application.output.CreateUserOutput;

public class UserWebMapper {
    public static CreateUserCommand toCommand(CreateUserRequest req) {
        return new CreateUserCommand(req.email(), req.name(), req.password());
    }

    public static CreateUserResponse toResponse(CreateUserOutput output) {
        return new CreateUserResponse(output.userId());
    }
}

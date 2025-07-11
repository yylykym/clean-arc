package com.yylykym.user.adapter.web;

import com.yylykym.user.adapter.web.mapper.UserWebMapper;
import com.yylykym.user.adapter.web.request.CreateUserRequest;
import com.yylykym.user.adapter.web.response.CreateUserResponse;
import com.yylykym.user.application.command.CreateUserCommand;
import com.yylykym.user.application.output.CreateUserOutput;
import com.yylykym.user.application.usecase.CreateUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    @Operation(
            summary = "创建新用户",
            description = "根据前端传入的注册信息，创建一个新的用户账号"
    )
    @ApiResponse(
            responseCode = "201",
            description = "用户创建成功",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CreateUserResponse.class)
            )
    )
    public CreateUserResponse create(@Valid @RequestBody CreateUserRequest request) {
        CreateUserCommand command = UserWebMapper.toCommand(request);
        CreateUserOutput output = createUserUseCase.execute(command);
        return UserWebMapper.toResponse(output);
    }
}
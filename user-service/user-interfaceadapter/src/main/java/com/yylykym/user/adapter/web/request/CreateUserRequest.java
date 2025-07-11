package com.yylykym.user.adapter.web.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank
        @Email(message = "INVALID_EMAIL")
        @Schema(description = "注册用的邮箱地址，必须符合邮箱格式")
        String email,

        @NotBlank(message = "INVALID_NAME")
        @Schema(description = "用户的显示名称")
        String name,

        @NotBlank
        @Size(min = 8, max = 20, message = "INVALID_PASSWORD")
        @Schema(description = "用户密码，长度 8–20 位，须包含大小写字母和数字")
        String password
) {}

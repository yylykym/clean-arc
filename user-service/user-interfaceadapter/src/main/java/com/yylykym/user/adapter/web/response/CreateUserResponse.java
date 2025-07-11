package com.yylykym.user.adapter.web.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateUserResponse(
        @Schema(description = "系统生成的用户 ID", example = "1024")
        String id
) {}
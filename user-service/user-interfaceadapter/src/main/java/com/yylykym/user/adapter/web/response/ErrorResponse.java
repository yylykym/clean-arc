package com.yylykym.user.adapter.web.response;


public record ErrorResponse(
        String code,   // e.g. "USER_ALREADY_EXISTS"
        String message // 本地化后要返回给前端的文案
) {}

package com.yylykym.user.domain.exception;

public class DomainException extends RuntimeException{
    private final UserErrorCode code;
    public DomainException(UserErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    public UserErrorCode getCode() {
        return code;
    }
}

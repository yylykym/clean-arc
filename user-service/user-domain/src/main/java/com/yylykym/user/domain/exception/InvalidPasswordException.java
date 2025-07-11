package com.yylykym.user.domain.exception;

public class InvalidPasswordException extends DomainException {
    public InvalidPasswordException(String message) {
        super(UserErrorCode.INVALID_PASSWORD, message);
    }
}

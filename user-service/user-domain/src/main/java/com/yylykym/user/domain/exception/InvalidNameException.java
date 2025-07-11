package com.yylykym.user.domain.exception;

public class InvalidNameException extends DomainException {
    public InvalidNameException(String message) {
        super(UserErrorCode.INVALID_NAME, message);
    }
}

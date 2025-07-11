package com.yylykym.user.domain.exception;

public class InvalidEmailException extends DomainException  {
    public InvalidEmailException(String message) {
        super(UserErrorCode.INVALID_EMAIL,message);
    }
}

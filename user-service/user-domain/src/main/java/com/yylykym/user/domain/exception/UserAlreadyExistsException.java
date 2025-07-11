package com.yylykym.user.domain.exception;

public class UserAlreadyExistsException extends DomainException  {
    public UserAlreadyExistsException(String message) {
        super(UserErrorCode.USER_EXISTS, message);
    }
}

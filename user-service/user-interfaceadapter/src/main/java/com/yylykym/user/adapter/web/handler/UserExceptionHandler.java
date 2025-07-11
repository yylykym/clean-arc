package com.yylykym.user.adapter.web.handler;

import com.yylykym.user.adapter.web.response.ErrorResponse;
import com.yylykym.user.domain.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class UserExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(UserExceptionHandler.class);

    private final MessageSource messageSource;

    public UserExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // 捕获领域相关异常，返回 400 Bad Request
    @ExceptionHandler({
            InvalidEmailException.class,
            InvalidNameException.class,
            InvalidPasswordException.class,
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidInput(DomainException ex) {
        String code = ex.getCode().name();
        String message = messageSource.getMessage(
                code,
                null,                    // 占位参数（如果有的话）
                code,                             // fallback：没找到就返回 code 本身
                LocaleContextHolder.getLocale()   // 当前请求的 Locale
        );
        log.warn("Bad request [{}]: {}", code, message);
        return new ErrorResponse(ex.getCode().name(), message);
    }

    // 业务冲突，返回 409 Conflict
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ErrorResponse handleUserAlreadyExists(UserAlreadyExistsException ex) {
        String code = ex.getCode().name();
        String message = messageSource.getMessage(
                code,
                null,
                code,
                LocaleContextHolder.getLocale()
        );
        log.warn("Conflict [{}]: {}", code, message);
        return new ErrorResponse(ex.getCode().name(), message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidation(MethodArgumentNotValidException ex) {
        // 取第一个字段错误，也可以汇总多个
        FieldError fe = ex.getBindingResult().getFieldErrors().get(0);
        String code    = fe.getDefaultMessage();
        assert code != null;
        String message = messageSource.getMessage(code, null, code, LocaleContextHolder.getLocale());
        log.warn("Bad request [{}]: {}", code, message);
        return new ErrorResponse(code, message);
    }

    // 其他未处理的异常（可选），返回 500
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleOther(Exception ex, HttpServletRequest req) {
        String message = messageSource.getMessage(
                UserErrorCode.INTERNAL_SERVER_ERROR.name(),
                null,
                UserErrorCode.INTERNAL_SERVER_ERROR.name(),
                LocaleContextHolder.getLocale()
        );
        log.error("Unexpected error at [{} {}]: {}",
                req.getMethod(), req.getRequestURI(), message, ex);
        return new ErrorResponse(UserErrorCode.INTERNAL_SERVER_ERROR.name(), message);
    }

}

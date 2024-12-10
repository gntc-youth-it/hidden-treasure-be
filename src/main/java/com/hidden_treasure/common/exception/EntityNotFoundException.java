package com.hidden_treasure.common.exception;

import com.hidden_treasure.common.exception.model.ExceptionCode;
import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {

    private final int code;
    private final String message;

    public EntityNotFoundException(final ExceptionCode exceptionCode) {
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
    }
}

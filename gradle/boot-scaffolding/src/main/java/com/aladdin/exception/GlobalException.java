package com.aladdin.exception;

import com.aladdin.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

/**
 * @author lgc
 **/
@Slf4j
@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        logger.error(ex.getMessage(), ex);
        Result respMsg = Result.failure(status.value(), ex.getMessage(), null);
        return new ResponseEntity<>(respMsg, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuffer sb = new StringBuffer();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            sb.append(error.getDefaultMessage()).append(";");
        });
        Result respMsg = Result.failure(status.value(), sb.toString(), null);
        return new ResponseEntity<>(respMsg, headers, HttpStatus.OK);
    }
}

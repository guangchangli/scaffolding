package com.aladdin.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author lgc
 **/
@Data
@Builder
public class Result<T> {
    private int code;
    private String errMsg;
    private boolean success;
    private T data;

    public static Result failure(int code, String errMsg, Object data) {
        return Result.builder().code(code).errMsg(errMsg).success(false).data(data).build();
    }

    public static Result success(Object data) {
        return Result.builder().code(HttpStatus.OK.value()).errMsg(null).success(true).data(data).build();
    }
}

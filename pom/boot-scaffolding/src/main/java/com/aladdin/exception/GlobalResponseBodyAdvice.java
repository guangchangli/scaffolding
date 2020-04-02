package com.aladdin.exception;

import com.aladdin.common.ResponseResult;
import com.aladdin.common.ResponseResultBuilder;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@Slf4j
@RestControllerAdvice(basePackages = {"com.aladdin.controller"})
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    //这个方法表示对于哪些请求要执行beforeBodyWrite，返回true执行，返回false不执行
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    //对于返回的对象如果不是最终对象ResponseResult，则选包装一下
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (!(o instanceof ResponseResult)) {
            ResponseResult responseResult = new ResponseResult(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), o);
            if (o instanceof String) {
                return JSON.toJSONString(responseResult);
            }
            return responseResult;
        }
        return o;
    }

    /**
     * 全局异常捕捉处理
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseResult errorHandler(Exception ex) {
        ex.printStackTrace();
        return ResponseResultBuilder.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

    /**
     * 拦截捕捉业务异常
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResponseResult BusinessExceptionHandler(BusinessException ex) {
        ex.printStackTrace();
        return ResponseResultBuilder.error(ex.getErrCode(), ex.getErrMsg());
    }


}
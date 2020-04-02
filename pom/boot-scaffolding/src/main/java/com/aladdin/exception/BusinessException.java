package com.aladdin.exception;

import com.aladdin.common.ResponseResult;
import lombok.Getter;

/**
 * @author lgc
 **/
@Getter
public class BusinessException  extends RuntimeException{
    private int errCode;
    private String errMsg;
    public BusinessException(int errCode,String errMsg){
        super(errMsg);
        this.errCode=errCode;
        this.errMsg=errMsg;
    }
    public BusinessException(ResponseResult responseResult){
        super(responseResult.getMsg());
        this.errCode=responseResult.getCode();
        this.errMsg=responseResult.getMsg();
    }
}

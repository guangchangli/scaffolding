package com.aladdin.common;

public class ResponseResultBuilder {

    private static Integer successCode = EnumErrCode.SUCCESS.getCode();
    private static String successMsg = EnumErrCode.SUCCESS.getMsg();

    //成功，不返回具体数据
    public static ResponseResult<String> success(){
        ResponseResult<String> result = new ResponseResult<>();
        result.setCode(successCode);
        result.setMsg(successMsg);
        result.setData("");
        return result;
    }
    //成功，返回数据
    public static <T> ResponseResult<T> success(T t){
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(successCode);
        result.setMsg(successMsg);
        result.setData(t);
        return result;
    }

    //失败，返回失败信息
    public static <T> ResponseResult<T> error(EnumErrCode code){
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }

    //失败，返回失败信息
    public static <T> ResponseResult<T> error(EnumErrCode code,String extraMsg){
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg() + "," + extraMsg);
        return result;
    }

    //失败，返回失败信息
    public static <T> ResponseResult<T> error(Integer code,String extraMsg){
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(code);
        result.setMsg(extraMsg);
        return result;
    }

}
package com.common.util;


import com.domian.Result;
import com.common.enums.ExceptionEnum;
import com.common.enums.SystemExceptionEnum;

/**
 * @author Hu
 * resultutil to form the result
 * 结果封装，统一输出结果以及异常
 */
public class ResultUtil {

    /**
     * 返回成功，传入返回体具体出參
     *
     * @param t
     * @return
     */
    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<>();
        result.setCode(SystemExceptionEnum.SUCCESS.getCode());
        result.setMsg(SystemExceptionEnum.SUCCESS.getMsg());
        result.setData(t);
        result.setSuccess(true);
        return result;
    }

    /**
     * 提供给部分不需要出參的接口
     *
     * @return
     */
    public static <T> Result<T> success() {
        return success(null);
    }

    /**
     * 自定义错误信息
     *
     * @param msg
     * @param msg
     * @return
     */
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setMsg(msg);
        result.setData(null);
        result.setSuccess(false);
        return result;
    }

    /**
     * 返回异常信息，在已知的范围内
     *
     * @param exceptionEnum
     * @return
     */
    public static <T> Result<T> error(ExceptionEnum exceptionEnum) {
        Result<T> result = new Result<>();
        result.setCode(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setSuccess(false);
        result.setData(null);
        return result;
    }

    /**
     * 错误返回
     * @param code 错误码
     * @param msg  错误信息
     * @param <T>  泛型
     * @return
     */
    public static <T> Result<T> error(Integer code, String msg){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);
        result.setData(null);
        return result;
    }

    /**
     * 错误返回
     * @param code 错误码
     * @param msg  错误信息
     * @param t    详细数据
     * @param <T>  泛型
     * @return
     */
    public static <T> Result<T> error(Integer code, String msg, T t){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);
        result.setData(t);
        return result;
    }

}

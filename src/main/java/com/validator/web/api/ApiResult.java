package com.validator.web.api;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * API返回结果值封装
 *
 * @author chenw
 * @create 2016-12-29 17:16
 * @email javacspring@gmail.com
 */
public class ApiResult<T extends Object> implements Serializable{

    public static final int RESULT_SUCC = 200;
    private static final long serialVersionUID = -1596869236780513386L;
    private boolean succ;
    private int status;
    private String msg;
    private T data;

    public ApiResult() {
        this(RESULT_SUCC, true, "", null);
    }

    public ApiResult(String message) {
        this(RESULT_SUCC, true, message, null);
    }

    public ApiResult(int status, String message) {
        this(status, RESULT_SUCC == status, message, null);
    }

    public ApiResult(int status, T data) {
        this(status, RESULT_SUCC == status, "", data);
    }

    public ApiResult(T data) {
        this(RESULT_SUCC, true, "", data);
    }

    public ApiResult(int status, boolean success) {
        this(status, success, "", null);
    }

    public ApiResult(int status, boolean succ, T data) {
        this(status, succ, "", data);
    }

    public ApiResult(int status, boolean succ, String message) {
        this(status, succ, message, null);
    }

    public ApiResult(int status, boolean succ, String msg, T data) {
        this.succ = succ;
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public ApiResult<T> success() {
        return success(RESULT_SUCC, this.msg, this.data);
    }

    public ApiResult<T> success(String message) {
        return success(message, this.data);
    }

    public ApiResult<T> success(T data) {
        return success(this.msg, data);
    }

    public ApiResult<T> success(String message, T data) {
        return success(RESULT_SUCC, message, data);
    }

    public ApiResult<T> success(int status, String message, T data) {
        this.succ = true;
        this.status = status;
        this.msg = message;
        this.data = data;
        return this;
    }

    public ApiResult<T> failure() {
        this.succ = false;
        return this;
    }

    public ApiResult<T> failure(String message) {
        this.succ = false;
        this.msg = message;
        return this;
    }

    public ApiResult<T> failure(T data) {
        this.succ = false;
        this.data = data;
        return this;
    }

    public ApiResult<T> failure(int status) {
        return failure(status, this.msg, this.data);
    }

    public ApiResult<T> failure(int status, String message) {
        return failure(status, message, this.data);
    }

    public ApiResult<T> failure(int status, T data) {
        return failure(status, this.msg, data);
    }

    public ApiResult<T> failure(int status, String message, T data) {
        this.succ = false;
        this.status = status;
        this.msg = message;
        this.data = data;
        return this;
    }

    public boolean isSucc() {
        return succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ApiResult error(BindingResult bindingResult) {
        List<ObjectError> errors = bindingResult.getAllErrors();
        return new ApiResult<LinkedHashMap<String, String>>(
                new LinkedHashMap<String, String>(errors.size()) {{
                    for (ObjectError error : errors) {
                        put(((FieldError) error).getField(), error.getDefaultMessage());
                    }
                }}).failure(100101, "表单参数检验失败");
    }
}

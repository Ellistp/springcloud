package com.ctp.study.vo;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * @author chengtianping
 * @description 返回结果
 * @date 2017/8/8
 */
public class Result<T> implements Serializable{

    private static final long serialVersionUID = 2318866198328783813L;

    private T data;

    private boolean ok = true;

    private String code = HttpStatus.OK.toString();

    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

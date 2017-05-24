package com.jlju.docmanager.dto;

import java.util.List;

/**
 * User: 张月忠
 * Date: 2017/5/23
 * Time: 下午11:34
 * To change this template use File | Settings | File Templates.
 */

public class SugResult <T>{
    private String message;
    private int code;
    private List<T> value;
    private String redirect;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<T> getValue() {
        return value;
    }

    public void setValue(List<T> value) {
        this.value = value;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public SugResult(String message, int code, List<T> value, String redirect) {
        this.message = message;
        this.code = code;
        this.value = value;
        this.redirect = redirect;
    }
}

package com.novatec.test.models.dto;

import java.util.ArrayList;

public class Response<E> {
    private Integer code;
    private ArrayList<String> errors;
    private E response;

    public Response(Integer code, ArrayList<String> errors, E response) {
        this.code = code;
        this.errors = errors;
        this.response = response;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }

    public E getResponse() {
        return response;
    }

    public void setResponse(E response) {
        this.response = response;
    }
}

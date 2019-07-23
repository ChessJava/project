package com.test.entity;

import java.io.Serializable;

public class Result implements Serializable {

    private int status;
    private String result;
    private Object object;

    public Result(int status, String result, Object object) {
        this.status = status;
        this.result = result;
        this.object = object;
    }

    public Result() {
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result result1 = (Result) o;

        if (status != result1.status) return false;
        return result.equals(result1.result);

    }

    @Override
    public int hashCode() {
        int result1 = status;
        result1 = 31 * result1 + result.hashCode();
        return result1;
    }
}

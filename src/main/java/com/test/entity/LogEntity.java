package com.test.entity;

import java.util.Arrays;

public class LogEntity {

    private String url;
    private String http_method;
    private String ip;
    private String class_method;
    private String args;

    public LogEntity() {
    }

    public LogEntity(String url, String http_method, String ip, String class_method, String args) {
        this.url = url;
        this.http_method = http_method;
        this.ip = ip;
        this.class_method = class_method;
        this.args = args;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHttp_method() {
        return http_method;
    }

    public void setHttp_method(String http_method) {
        this.http_method = http_method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClass_method() {
        return class_method;
    }

    public void setClass_method(String class_method) {
        this.class_method = class_method;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LogEntity)){
            return false;
        }

        LogEntity logEntity = (LogEntity) o;

        if (url != null ? !url.equals(logEntity.url) : logEntity.url != null){
            return false;
        }
        if (http_method != null ? !http_method.equals(logEntity.http_method) : logEntity.http_method != null) {
            return false;
        }
        if (ip != null ? !ip.equals(logEntity.ip) : logEntity.ip != null) {
            return false;
        }
        if (class_method != null ? !class_method.equals(logEntity.class_method) : logEntity.class_method != null) {
            return false;
        }
        return args != null ? args.equals(logEntity.args) : logEntity.args == null;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (http_method != null ? http_method.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (class_method != null ? class_method.hashCode() : 0);
        result = 31 * result + (args != null ? args.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "url='" + url + '\'' +
                ", http_method='" + http_method + '\'' +
                ", ip='" + ip + '\'' +
                ", class_method='" + class_method + '\'' +
                ", args='" + args + '\'' +
                '}';
    }
}

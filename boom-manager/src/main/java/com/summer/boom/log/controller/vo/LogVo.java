package com.summer.boom.controller.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/28 下午2:57
 * @Description 前端日志实体对象
 */
public class LogVo implements Serializable {
    private static final long serialVersionUID = -2932100556042724160L;

    /**日志标识ID*/
    private Long id;
    /**操作用户名*/
    private String username;
    /**操作*/
    private String operation;
    /**请求方法*/
    private String method;
    /**请求参数*/
    private String parameters;
    /**操作电脑IP地址*/
    private String ip;
    /**日志操作日期*/
    private Date createDate;

    public LogVo(Long id, String username, String operation, String method, String parameters, String ip, Date createDate) {
        this.id = id;
        this.username = username;
        this.operation = operation;
        this.method = method;
        this.parameters = parameters;
        this.ip = ip;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

package com.summer.boom.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/21 下午3:40
 * @Description 用户
 */
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1382072913492563221L;

    /**用户id*/
    private Long id;
    /**用户名*/
    private String username;
    /**用户密码*/
    private String password;
    /**用户密码加密密钥*/
    private String salt;
    /**用户邮箱*/
    private String email;
    /**状态，0：禁用，1：正常*/
    private Integer status;
    /**用户手机*/
    private String phone;
    /**用户头像url地址*/
    private String photo;
    /**创建者id*/
    private Long createUserId;
    /**创建日期*/
    private Date createTime;
    /**角色id*/
    private List<Long> roleIds;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}

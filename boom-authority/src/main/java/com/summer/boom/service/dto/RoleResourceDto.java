package com.summer.boom.service.dto;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/21 下午3:44
 * @Description 角色与资源关系
 */
public class RoleResourceDto implements Serializable {
    private static final long serialVersionUID = 5926898076501165131L;

    /**id*/
    private Long id;
    /**角色id*/
    private Long roleId;
    /**资源id*/
    private Long resourceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}

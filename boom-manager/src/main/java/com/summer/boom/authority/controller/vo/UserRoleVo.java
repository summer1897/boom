package com.summer.boom.controller.vo;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/21 下午3:36
 * @Description 用户与角色对应关系
 */
public class UserRoleVo implements Serializable {
    private static final long serialVersionUID = -5755863718742056042L;

    /**id*/
    private Long id;
    /**用户id*/
    private Long userId;
    /**角色id*/
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}

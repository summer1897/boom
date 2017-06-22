package com.summer.boom.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/21 下午3:40
 * @Description 角色
 */
public class RoleDto implements Serializable {
    private static final long serialVersionUID = -3793282485659926475L;

    /**角色id*/
    private Long id;
    /**角色名称*/
    private String name;
    /**角色备注*/
    private String remark;
    /**是否可用,0：禁用，1：可用*/
    private Integer available;
    /**创建者id*/
    private Long creatUserId;
    /**创建日期*/
    private Date createTime;
    /**资源id列表*/
    private List<Long> resourceIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Long getCreatUserId() {
        return creatUserId;
    }

    public void setCreatUserId(Long creatUserId) {
        this.creatUserId = creatUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Long> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(List<Long> resourceIds) {
        this.resourceIds = resourceIds;
    }
}

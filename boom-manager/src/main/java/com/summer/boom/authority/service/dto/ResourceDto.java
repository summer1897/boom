package com.summer.boom.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/21 下午3:41
 * @Description 资源
 */
public class ResourceDto implements Serializable {
    private static final long serialVersionUID = 3420004856490004424L;

    public static final long ROOT_ID = 0L;

    /**资源id*/
    private Long id;
    /**父级资源id,主要用于表示目录或菜单*/
    private Long parentId;
    /**资源名称*/
    private String name;
    /**资源描述*/
    private String description;
    /**url访问地址，主要用于菜单导航*/
    private String url;
    /**授权信息，如：user:create,menu:**/
    private String permission;
    /**类型，0：目录，1：菜单，2：按钮*/
    private Integer type;
    /**排序优先级*/
    private Integer priority;
    /**是否可用，0：禁用，1：正常*/
    private Integer available;
    /**用于子菜单迭代填充*/
    private List<ResourceDto> subResources;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public List<ResourceDto> getSubResources() {
        return this.subResources;
    }

    public void setSubResources(List<ResourceDto> subResources) {
        this.subResources = subResources;
    }
}

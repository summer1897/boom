package com.summer.boom.dao;

import com.summer.boom.domain.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/22 上午10:54
 * @Description dao层角色操作接口
 */
@Repository
public interface RoleMapper {
    /**
     * 创建角色
     * @param role
     * @return
     */
    Role createRole(Role role);

    /**
     * 删除角色
     * @param roleId
     */
    void deleteRole(Long roleId);

    /**
     * 添加角色-权限关系
     * @param roleId
     * @param permissionIds 权限标识id,可以是一个角色关联多个权限
     */
    void correlationPermission(Long roleId, Long... permissionIds);

    /**
     * 删除角色与某些权限的关系
     * @param roleId
     * @param permissionIds
     */
    void uncorrelationPermission(Long roleId, Long... permissionIds);
}

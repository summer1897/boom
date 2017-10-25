package com.summer.boom.dao;

import com.summer.boom.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/22 上午10:41
 * @Description dao层用户操作接口
 */
@Repository
public interface UserMapper {

    /**
     * 查询所有用户信息
     * @return {@List<User>}
     */
    List<User> queryAll();

    /**
     * 添加用户
     * @param user {@see com.summer.boom.domain.User}
     * @return 返回添加记录数
     */
    int addUser(User user);

    /**
     * 删除某用户
     * @param userId
     * @return 返回删除记录数
     */
    int deleteUser(@Param("userId") Long userId);

    /**
     * 更新用户信息
     * @param user
     * @return 返回更新记录数
     */
    int updateUser(User user);

    /**
     * 修改密码
     * @param userId 用户ID
     * @param newPassword 新密码
     * @param newSalt 新salt
     * @return 返回更新记录数
     */
    int changePassword(@Param("userId") Long userId,@Param("newPassword") String newPassword,@Param("newSalt") String newSalt);

    /**
     * 通过用户ID查找用户
     * @param userId
     * @return {@see com.summer.boom.domain.User}
     */
    User queryById(@Param("userId") Long userId);

    /**
     * 通过用户名查找用户
     * @param username
     * @return {@see com.summer.boom.domain.User}
     */
    User queryByName(@Param("username") String username);

    /**
     * 账号/密码查找用户,账号可以是用户名、手机号或者邮箱
     * @param account 账号
     * @param password 密码
     * @return {@see com.summer.boom.domain.User}
     */
    User queryByAccountAndPassword(@Param("account") String account,@Param("password") String password);

    /**
     * 通过用户邮箱查找用户
     * @param email
     * @return {@see com.summer.boom.domain.User}
     */
    User queryByEmail(@Param("email") String email);

    /**
     * 通过用户手机号查找用户
     * @param phone
     * @return {@see com.summer.boom.domain.User}
     */
    User queryByPhone(@Param("phone") String phone);

    /**
     * 根据用户ID查询用户的所有角色
     * @param userId
     * @return {@Set<String>}
     */
    Set<String> findRoles(@Param("userId") Long userId);

    /**
     * 根据用户ID查询用户所有权限
     * @param userId
     * @return {@Set<String>}
     */
    Set<String> findPermissions(@Param("userId") Long userId);

    /**
     * 关联用户与某些角色
     * @param userId
     * @param roleIds 一个用户可以关联多个角色
     */
    void correlationRole(@Param("userId") Long userId, @Param("roleIds") Long... roleIds);

    /**
     * 移除用户与某些角色的关联关系
     * @param userId
     * @param roleIds
     */
    void uncorrelatoinRole(@Param("userId") Long userId, @Param("roleIds") Long... roleIds);

}

package com.summer.boom.service;

import com.summer.boom.controller.vo.UserVo;

import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/27 下午4:04
 * @Description Service层用户操作接口
 */
public interface IUserService {
    /**
     * 查询所有用户信息
     * @return {@List<User>}
     */
    List<UserVo> queryAll();

    /**
     * 添加用户
     * @param userVo {@see com.summer.boom.controller.vo.User}
     * @return 返回添加记录数
     */
    int addUser(UserVo userVo);

    /**
     * 删除某用户
     * @param userId
     * @return 返回删除记录数
     */
    int deleteUser(Long userId);

    /**
     * 更新用户信息
     * @param userVo
     * @return 返回更新记录数
     */
    int updateUser(UserVo userVo);

    /**
     * 修改密码
     * @param userId 用户ID
     * @param newPassword 新密码
     * @return 返回更新记录数
     */
    int changePassword(Long userId,String newPassword);

    /**
     * 通过用户ID查找用户
     * @param userId
     * @return {@see com.summer.boom.controller.vo.User}
     */
    UserVo queryById(Long userId);

    /**
     * 通过用户名查找用户
     * @param username
     * @return {@see com.summer.boom.controller.vo.User}
     */
    UserVo queryByName(String username);

    /**
     * 账号/密码查找用户,账号可以是用户名、手机号或者邮箱
     * @param account 账号
     * @param password 密码
     * @return {@see com.summer.boom.controller.vo.User}
     */
    UserVo loginValidate(String account,String password);

    /**
     * 通过用户邮箱查找用户
     * @param email
     * @return {@see com.summer.boom.controller.vo.User}
     */
    UserVo queryByEmail(String email);

    /**
     * 通过用户手机号查找用户
     * @param phone
     * @return {@see com.summer.boom.controller.vo.User}
     */
    UserVo queryByPhone(String phone);

    /**
     * 根据用户ID查询用户的所有角色
     * @param userId
     * @return {@Set<String>}
     */
    Set<String> findRoles(Long userId);

    /**
     * 根据用户ID查询用户所有权限
     * @param userId
     * @return {@Set<String>}
     */
    Set<String> findPermissions(Long userId);

    /**
     * 关联用户与某些角色
     * @param userId
     * @param roleIds 一个用户可以关联多个角色
     */
    void correlationRole(Long userId, Long... roleIds);

    /**
     * 移除用户与某些角色的关联关系
     * @param userId
     * @param roleIds
     */
    void uncorrelatoinRole(Long userId, Long... roleIds);

}

package com.summer.boom.dao;

import com.summer.boom.domain.WebUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/29 下午5:31
 * @Description 登录控制操作
 */
@Repository
public interface LoginMapper {

    /**
     * 账号/密码查找用户,账号可以是用户名、手机号或者邮箱
     * @param account 账号
     * @param password 密码
     * @return {@see com.summer.boom.controller.WebUser}
     */
    WebUser queryByAccountAndPassword(@Param("account") String account, @Param("password") String password);
}

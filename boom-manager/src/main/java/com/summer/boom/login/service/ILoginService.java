package com.summer.boom.service;

import com.summer.boom.service.dto.WebUserDto;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/29 下午5:35
 * @Description Service层登录操作接口
 */
public interface ILoginService {

    /**
     * 账号/密码查找用户,账号可以是用户名、手机号或者邮箱
     * @param account 账号
     * @param password 密码
     * @return {@see com.summer.boom.controller.WebUser}
     */
    WebUserDto loginValidate(String account, String password);
}

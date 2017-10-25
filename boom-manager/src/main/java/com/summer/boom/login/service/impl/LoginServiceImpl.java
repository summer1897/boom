package com.summer.boom.service.impl;

import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.StringUtils;
import com.summer.boom.dao.LoginMapper;
import com.summer.boom.domain.WebUser;
import com.summer.boom.service.ILoginService;
import com.summer.boom.service.dto.WebUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/29 下午5:41
 * @Description
 */
@Service("loginService")
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private LoginMapper loginMapper;

    public WebUserDto loginValidate(String account, String password) {
        WebUserDto webUserDto = null;
        if (StringUtils.isNotEmpty(account) && StringUtils.isNotEmpty(password)) {
            WebUser webUser = loginMapper.queryByAccountAndPassword(account,password);
            if (ObjectUtils.isNotNull(webUser)) {
                webUserDto = BeanCloneUtils.clone(webUser,WebUser.class,WebUserDto.class);
            }
        }
        return webUserDto;
    }
}

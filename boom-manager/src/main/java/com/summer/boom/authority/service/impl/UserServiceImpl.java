package com.summer.boom.service.impl;

import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.StringUtils;
import com.summer.boom.controller.vo.UserVo;
import com.summer.boom.dao.UserMapper;
import com.summer.boom.domain.User;
import com.summer.boom.service.IUserService;
import com.summer.boom.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/27 下午4:06
 * @Description Service层用户操作接口实现
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordHelper passwordHelper;

    public List<UserVo> queryAll() {
        List<User> users = userMapper.queryAll();
        List<UserVo> userVos = null;
        if (!ObjectUtils.isEmptyList(users)) {
            userVos = BeanCloneUtils.clone(users,User.class,UserVo.class);
        }
        return userVos;
    }

    public int addUser(UserVo userVo) {
        int result = 0;
        User user = null;
        if (ObjectUtils.isNotNull(userVo)) {
            user = BeanCloneUtils.clone(userVo,UserVo.class,User.class);
        }
        result = userMapper.addUser(user);
        return result;
    }

    public int deleteUser(Long userId) {
        return userMapper.deleteUser(userId);
    }

    public int updateUser(UserVo userVo) {
        int result = 0;
        User user = null;
        if (ObjectUtils.isNotNull(userVo)) {
            user = BeanCloneUtils.clone(userVo,UserVo.class,User.class);
        }
        result =  userMapper.updateUser(user);
        return result;
    }

    public int changePassword(Long userId, String newPassword) {
        UserVo userVo = new UserVo(userId,newPassword);
        passwordHelper.encryptPassword(userVo);
        return userMapper.changePassword(userVo.getId(),userVo.getPassword(),userVo.getSalt());
    }

    public UserVo queryById(Long userId) {
        UserVo userVo = null;
        if (ObjectUtils.isNotNull(userId)) {
            return userVo;
        }
        User user = userMapper.queryById(userId);
        if (ObjectUtils.isNotNull(user)) {
            userVo = BeanCloneUtils.clone(user,User.class,UserVo.class);
        }
        return userVo;
    }

    public UserVo queryByName(String username) {
        UserVo userVo = null;
        if (StringUtils.isNotEmpty(username)) {
            return userVo;
        }
        User user = userMapper.queryByName(username);
        if (ObjectUtils.isNotNull(user)) {
            userVo = BeanCloneUtils.clone(user,User.class,UserVo.class);
        }
        return userVo;
    }

    public UserVo loginValidate(String account, String password) {
        User user = userMapper.queryByAccountAndPassword(account,password);
        UserVo userVo = null;
        if (ObjectUtils.isNotNull(user)) {
            userVo = BeanCloneUtils.clone(user,User.class,UserVo.class);
        }
        return userVo;
    }

    public UserVo queryByEmail(String email) {
        return null;
    }

    public UserVo queryByPhone(String phone) {
        UserVo userVo = null;
        if ((StringUtils.isNotEmpty(phone))) {
            return userVo;
        }
        User user = userMapper.queryByPhone(phone);
        if (ObjectUtils.isNotNull(user)) {
            userVo = BeanCloneUtils.clone(user,User.class,UserVo.class);
        }
        return userVo;
    }

    public Set<String> findRoles(Long userId) {
        return null;
    }

    public Set<String> findPermissions(Long userId) {
        return null;
    }

    public void correlationRole(Long userId, Long... roleIds) {

    }

    public void uncorrelatoinRole(Long userId, Long... roleIds) {

    }
}

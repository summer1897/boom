package com.summer.boom.utils;

import com.summer.boom.controller.vo.UserVo;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/21 下午2:39
 * @Description 密码加密工具
 */
@Service("passwordHelper")
public class PasswordHelper {

    private RandomNumberGenerator generator = new SecureRandomNumberGenerator();

    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }
    public void setGenerator(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    public void encryptPassword(UserVo userVo) {
        userVo.setSalt(generator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                userVo.getPassword(),
                ByteSource.Util.bytes(userVo.getSalt()),
                hashIterations).toHex();
        userVo.setPassword(newPassword);
    }

}

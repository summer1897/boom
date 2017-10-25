package com.summer.boom.controller.html;

import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.boom.controller.vo.WebUserVo;
import com.summer.boom.service.ILoginService;
import com.summer.boom.service.dto.WebUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Intellij IDEA
 *  这里不能记录日志信息，应为这里还没有登录，只记录登录后的日志信息
 *
 * @Author summer
 * @Date 2017/6/27 下午3:45
 * @Description 登录Controller
 */
@Controller
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ILoginService loginService;


//    @SysLogAnnotation(operation = "登录请求")
    @RequestMapping(value = {"/login.html","login.htm"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

//    @SysLogAnnotation(operation = "登录请求处理")
    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String login(HttpServletRequest request,
                        @RequestParam(name = "account",required = true) String account,
                        @RequestParam(name = "password",required = true) String password) {
        String page = "login";
        WebUserDto webUserDto = loginService.loginValidate(account,password);
        if (ObjectUtils.isNotNull(webUserDto)) {
            WebUserVo webUserVo = BeanCloneUtils.clone(webUserDto,WebUserDto.class,WebUserVo.class);
            request.getSession().setAttribute(WebUserVo.LOGIN_USER_NAME,webUserVo);
//            LOG.info("user: " + webUserVo.getUsername());
            page = "redirect:index.html";
        }
        return page;
    }

}

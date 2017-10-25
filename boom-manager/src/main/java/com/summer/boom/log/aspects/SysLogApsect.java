package com.summer.boom.aspects;

import com.summer.base.utils.IPUtils;
import com.summer.boom.annotations.SysLogAnnotation;
import com.summer.boom.controller.vo.WebUserVo;
import com.summer.boom.service.ILogService;
import com.summer.boom.service.dto.LogDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/29 下午8:21
 * @Description 日志切面
 */
@Aspect
@Component
public class SysLogApsect {

    private static final Logger LOG = LoggerFactory.getLogger(SysLogApsect.class);
    private static final String REQUEST_METHOD_NAME = "requestMethodName";
    private static final String OPERATION = "operation";

    @Autowired
    private ILogService logService;

    //Controller层切点
    @Pointcut("@annotation(com.summer.boom.annotations.SysLogAnnotation)")
    public void controllerAspect(){
    }

    /**
     * 前置通知，在每个请求Controller之前记录日志
     * @param joinPoint
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        LOG.info("------------记录日志信息------------");
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        WebUserVo webUserVo = (WebUserVo) request.getSession().getAttribute(WebUserVo.LOGIN_USER_NAME);
        String user = webUserVo.getUsername();
        String ip = IPUtils.getRequestIP(request);
        String queryString = request.getQueryString();
        String parameters = (null == queryString || "".equals(queryString.trim())) ? "{}" : queryString;
        Map<String,String> map = getControllerInfo(joinPoint);
        LogDto logDto = new LogDto(null,user,map.get(OPERATION),map.get(REQUEST_METHOD_NAME),parameters,ip,new Date());
//        LOG.error(JSON.toJSONString(logDto));
        logService.addLog(logDto);
    }

    /**
     * 解析并获取Controller的信息
     * @param joinPoint
     * @return {@java.util.Map<String,stirng>} 该Map集合中封装了operation，method信息
     */
    private Map<String,String> getControllerInfo(JoinPoint joinPoint) {
        Map<String,String> map = new HashMap<String, String>();
        //1.获取访问Controller类的全名称
        String className = joinPoint.getTarget().getClass().getName();
        //2.获取访问Controller类的方法名称
        String methodName = joinPoint.getSignature().getName();
//        LOG.info("method name: " + className + "." + methodName);
        //3.设置请求类的方法全称
        map.put(REQUEST_METHOD_NAME,className + "." + methodName);
        //4.获取SysLogAnnotation注释的值
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        SysLogAnnotation sysLogAnnotation =  method.getAnnotation(SysLogAnnotation.class);
        //5.设置操作名称
        map.put(OPERATION,sysLogAnnotation.operation());
        return map;
    }

}

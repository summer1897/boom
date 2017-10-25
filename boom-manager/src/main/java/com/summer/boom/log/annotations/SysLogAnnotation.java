package com.summer.boom.annotations;

import java.lang.annotation.*;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/29 下午8:17
 * @Description 系统日志注释
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogAnnotation {
    /**
     * 操作
     * @return
     */
    String operation() default "";
}

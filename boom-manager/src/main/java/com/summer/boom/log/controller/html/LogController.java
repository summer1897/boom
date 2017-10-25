package com.summer.boom.controller.html;

import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.boom.annotations.SysLogAnnotation;
import com.summer.boom.controller.vo.LogVo;
import com.summer.boom.service.ILogService;
import com.summer.boom.service.dto.LogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/29 下午10:25
 * @Description
 */
@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private ILogService logService;

    @SysLogAnnotation(operation = "查询所有日志（分页）")
    @RequestMapping(value = {"/queryAll.html","queryAll.htm"},method = RequestMethod.GET)
    @ResponseBody
    public List<LogVo> queryById(@RequestParam(value = "pageNum",required = true) Integer pageNum,
                                 @RequestParam(value = "pageSize",required = true) Integer pageSize) {
        List<LogDto> logDtos = logService.queryAllByPages(pageNum,pageSize);
        List<LogVo> logVos = null;
        if (ObjectUtils.isNotEmptyList(logDtos)) {
            logVos = BeanCloneUtils.clone(logDtos,LogDto.class,LogVo.class);
        }

        return logVos;
    }

    @SysLogAnnotation(operation = "通过日志ID查询日志")
    @RequestMapping(value = {"/queryById.html","queryById.htm"},method = RequestMethod.GET)
    @ResponseBody
    public List<LogVo> queryById(@RequestParam(value = "id",required = true) Long id) {
        List<LogDto> logDtos = logService.queryById(id);
        List<LogVo> logVos = null;
        if (ObjectUtils.isNotEmptyList(logDtos)) {
            logVos = BeanCloneUtils.clone(logDtos,LogDto.class,LogVo.class);
        }

        return logVos;
    }

    @SysLogAnnotation(operation = "通过操作用户查询日志")
    @RequestMapping(value = {"/queryByUser.html","queryByUser.htm"},method = RequestMethod.GET)
    @ResponseBody
    public List<LogVo> queryByUser(@RequestParam(value = "user",required = true) String user) {
        List<LogDto> logDtos = logService.queryByUser(user);
        List<LogVo> logVos = null;
        if (ObjectUtils.isNotEmptyList(logDtos)) {
            logVos = BeanCloneUtils.clone(logDtos,LogDto.class,LogVo.class);
        }

        return logVos;
    }
}

package com.summer.boom.controller.html;

import com.alibaba.fastjson.JSON;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.boom.controller.vo.ResourceVo;
import com.summer.boom.service.IResourceService;
import com.summer.boom.service.dto.ResourceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/26 下午4:22
 * @Description
 */
@Controller
@RequestMapping("/resource")
public class ResourceHtmlController {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceHtmlController.class);

    @Autowired
    private IResourceService resourceService;

    @RequestMapping(value = "/listResource.html",method = RequestMethod.GET)
    public ModelAndView listResources(Model model) {
        List<ResourceDto> resourceDtos = resourceService.queryAll();
        List<ResourceVo> resourceVos = null;
        if (!ObjectUtils.isEmptyList(resourceDtos)) {
            resourceVos = BeanCloneUtils.deepClone(resourceDtos,ResourceDto.class,ResourceVo.class);
//            LOG.error(JSON.toJSONString(resourceVos,true));
//            LOG.error("class name:" + resourceVos.get(0).getClass().getName());
        }
        return new ModelAndView("main","resourceVos",resourceVos);
    }
}

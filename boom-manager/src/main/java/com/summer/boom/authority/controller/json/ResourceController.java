package com.summer.boom.controller.json;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/21 下午4:02
 * @Description controller层资源访问映射
 */
@Controller
@RequestMapping("/authority")
public class ResourceController {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private IResourceService resourceService;

    @RequestMapping(value = "/resourceList.html", method = RequestMethod.GET)
    @ResponseBody
    public List<ResourceVo> resourceList(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        List<ResourceDto> resourceDtos = resourceService.queryAll();
        List<ResourceVo> resourceVos = null;

        if (!ObjectUtils.isEmptyList(resourceDtos)) {
            resourceVos = BeanCloneUtils.deepClone(resourceDtos,ResourceDto.class,ResourceVo.class);
        }

//        System.out.println(JSON.toJSONString(resourceVos,true));
        LOG.error(JSON.toJSONString(resourceVos,true));

        return resourceVos;
    }

}

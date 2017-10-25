package com.summer.boom.service.impl;

import com.alibaba.fastjson.JSON;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.boom.dao.ResourceMapper;
import com.summer.boom.domain.Resource;
import com.summer.boom.service.IResourceService;
import com.summer.boom.service.dto.ResourceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/21 下午3:54
 * @Description Resource服务层操作
 */
@Service("resourceService")
public class ResourceServiceImpl implements IResourceService {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    private ResourceMapper resourceMapper;

    public List<ResourceDto> queryAll() {

        List<Resource> resources = resourceMapper.queryAll();
        List<ResourceDto> resourceDtos = null;

        if (!ObjectUtils.isEmptyList(resources)) {
            resourceDtos  = BeanCloneUtils.deepClone(resources,Resource.class,ResourceDto.class);
        }

        List<ResourceDto> rootResourceDto = new ArrayList<ResourceDto>();
        for (ResourceDto resourceDto : resourceDtos) {
            Long parentId = resourceDto.getParentId();
            if (ResourceDto.ROOT_ID == parentId.longValue()) {
                List<ResourceDto> subResourceDtos = iterateResource(resourceDtos,resourceDto.getId());
                if (!ObjectUtils.isEmptyList(subResourceDtos)) {
                    resourceDto.setSubResources(subResourceDtos);
                }
                rootResourceDto.add(resourceDto);
            }
        }
//        LOG.info("the size of the root resource are: " + rootResourceDto.size());
//        LOG.info(JSON.toJSONString(rootResourceDto,true));
        return rootResourceDto;
    }

    /**
     * 级联填充菜单资源
     * @param resourceDtos
     * @param pid
     * @return {@List<ResourceDto}
     */
    private List<ResourceDto> iterateResource(List<ResourceDto> resourceDtos,Long pid) {
        List<ResourceDto> rootResourceDtos = new ArrayList<ResourceDto>();
        for (ResourceDto resourceDto : resourceDtos) {
            Long id = resourceDto.getId();
            Long parentId = resourceDto.getParentId();
            if (null != parentId) {
                if (pid.equals(parentId)) {
                    List<ResourceDto> subResourceDtos = iterateResource(resourceDtos,id);
                    if (!ObjectUtils.isEmptyList(subResourceDtos)) {
                        resourceDto.setSubResources(subResourceDtos);
                    }
                    rootResourceDtos.add(resourceDto);
                }
            }
        }
        return rootResourceDtos;
    }
}

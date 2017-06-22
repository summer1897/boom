package com.summer.boom.service.impl;

import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.boom.dao.ResourceMapper;
import com.summer.boom.domain.Resource;
import com.summer.boom.service.IResourceService;
import com.summer.boom.service.dto.ResourceDto;
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

    @Autowired
    private ResourceMapper resourceMapper;

    public List<ResourceDto> queryAll() {

        List<Resource> resources = resourceMapper.queryAll();
        List<ResourceDto> resourceDtos = null;

        if (!ObjectUtils.isEmptyList(resources)) {
            resourceDtos  = BeanCloneUtils.clone(resources,Resource.class,ResourceDto.class);
        }

        List<ResourceDto> rootResourceDto = new ArrayList<ResourceDto>();
        for (ResourceDto resourceDto : resourceDtos) {
            Long parentId = resourceDto.getParentId();
            if (null != parentId) {
                List<ResourceDto> subResourceDtos = iterateResource(resourceDtos,resourceDto.getId());
                resourceDto.setSubResources(subResourceDtos);
                rootResourceDto.add(resourceDto);
            }
        }

        return resourceDtos;
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
                    resourceDto.setSubResources(subResourceDtos);
                    rootResourceDtos.add(resourceDto);
                }
            }
        }
        return rootResourceDtos;
    }
}

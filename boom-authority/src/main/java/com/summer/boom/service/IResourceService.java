package com.summer.boom.service;

import com.summer.boom.service.dto.ResourceDto;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/21 下午3:52
 * @Description service层资源操作接口
 */
public interface IResourceService {

    /**
     * 获取所有资源列表
     * @return {@List<ResourceDto>}
     */
    List<ResourceDto> queryAll();
}

package com.summer.boom.dao;

import com.summer.boom.domain.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/21 下午3:50
 * @Description dao层资源操作接口
 */
@Repository
public interface ResourceMapper {

    /**
     * 获取所有资源列表
     * @return {@see List<Resource>}
     */
    List<Resource> queryAll();

    /**
     * 添加资源
     * @param resource
     * @return 返回添加记录数
     */
    int addResource(Resource resource);

    /**
     * 删除某资源
     * @param resourceId
     * @return 返回删除记录数
     */
    int deleteResource(Integer resourceId);
}

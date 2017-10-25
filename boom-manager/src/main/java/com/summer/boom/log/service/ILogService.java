package com.summer.boom.service;

import com.summer.boom.service.dto.LogDto;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/28 下午10:12
 * @Description Service层Log操作接口
 */
public interface ILogService {
    /**
     * 查询所有日志信息
     * @return {@List<Log>}
     */
    List<LogDto> queryAll();

    /**
     * 分页获取日志信息
     * @param pageNum 页面号
     * @param pageSize 当前页展示的日志数量
     * @return {@see com.summer.boom.service.dto.LogDto}
     */
    List<LogDto> queryAllByPages(Integer pageNum, Integer pageSize);

    /**
     * 根据日志Id查询日志信息
     * @param id
     * @return {@List<Log>}
     */
    List<LogDto> queryById(Long id);

    /**
     * 根据用户查询日志信息
     * @param username 用户名
     * @return {@List<LogDto>}
     */
    List<LogDto> queryByUser(String username);

    /**
     * 根据用户分页查询日志信息
     * @param username 用户名
     * @param pageNum 页面号
     * @param pageSize 当前页展示的日志数量
     * @return {@see com.summer.boom.service.dto.LogDto}
     */
    List<LogDto> queryByUserAndPages(String username, Integer pageNum, Integer pageSize);

    /**
     * 添加日志信息
     * @param logDto {@see com.summer.boom.service.dto.LogDto}
     * @return 返回添加成功后的日志数量
     */
    int addLog(LogDto logDto);

    /**
     * 批量插入日志信息
     * @param logDtos {@see List<com.summer.boom.service.dto.LogDto>}
     * @return 返回添加成功后的日志数量
     */
    int addLogs(List<LogDto> logDtos);

    /**
     * 以数组的形式批量插入日志信息
     * @param logDtos {@see List<com.summer.boom.service.dto.LogDto>}
     * @return 返回添加成功后的日志数量
     */
    int addLogs(LogDto... logDtos);

}

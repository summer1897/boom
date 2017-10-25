package com.summer.boom.dao;

import com.summer.boom.domain.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/28 下午2:52
 * @Description dao层日志操作接口
 */
@Repository
public interface LogMapper {

    /**
     * 查询所有日志信息
     * @return {@List<Log>}
     */
    List<Log> queryAll();

    /**
     * 根据日志Id查询日志信息
     * @param id
     * @return {@List<Log>}
     */
    List<Log> queryById(@Param("id") Long id);

    /**
     * 根据用户查询日志信息
     * @param username 用户名
     * @return {@List<Log>}
     */
    List<Log> queryByUser(@Param("username") String username);

    /**
     * 添加日志信息
     * @param log {@see com.summer.boom.domain.Log}
     * @return 返回添加成功后的日志数量
     */
    int addLog(Log log);

    /**
     * 批量插入日志信息
     * @param logs {@see List<com.summer.boom.domain.Log>}
     * @return 返回添加成功后的日志数量
     */
    int addLogs(List<Log> logs);
}

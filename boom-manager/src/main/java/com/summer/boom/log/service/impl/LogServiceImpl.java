package com.summer.boom.service.impl;

import com.github.pagehelper.PageHelper;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.boom.dao.LogMapper;
import com.summer.boom.domain.Log;
import com.summer.boom.service.ILogService;
import com.summer.boom.service.dto.LogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/28 下午10:20
 * @Description Service层日志操作接口实现
 */
@Service("logService")
public class LogServiceImpl implements ILogService {

    @Autowired
    private LogMapper logMapper;

    public List<LogDto> queryAll() {
        List<Log> logs = logMapper.queryAll();
        List<LogDto> logDtos = null;
        if (!ObjectUtils.isEmptyList(logs)) {
            logDtos = BeanCloneUtils.clone(logs,Log.class,LogDto.class);
        }
        return logDtos;
    }

    public List<LogDto> queryAllByPages(Integer pageNum, Integer pageSize) {
        PageHelper.offsetPage(pageNum,pageSize);
        return this.queryAll();
    }

    public List<LogDto> queryById(Long id) {
        List<LogDto> logDtos = null;
        if (null != id && id.longValue() > 0) {
            List<Log> logs = logMapper.queryById(id);
            if (!ObjectUtils.isEmptyList(logs)) {
                logDtos = BeanCloneUtils.clone(logs,Log.class,LogDto.class);
            }
        }
        return logDtos;
    }

    public List<LogDto> queryByUser(String username) {
        List<Log> logs = logMapper.queryByUser(username);
        List<LogDto> logDtos = null;
        if (!ObjectUtils.isEmptyList(logs)) {
            logDtos = BeanCloneUtils.clone(logs,Log.class,LogDto.class);
        }
        return logDtos;
    }

    public List<LogDto> queryByUserAndPages(String username, Integer pageNum, Integer pageSize) {
        PageHelper.offsetPage(pageNum,pageSize);
        return queryByUser(username);
    }

    public int addLog(LogDto logDto) {
        int number = 0;
        if (ObjectUtils.isNotNull(logDto)) {
            number = logMapper.addLog(BeanCloneUtils.clone(logDto,LogDto.class,Log.class));
        }
        return number;
    }

    public int addLogs(List<LogDto> logDtos) {
        int number = 0;
        if (!ObjectUtils.isEmptyList(logDtos)) {
            List<Log> logs = BeanCloneUtils.clone(logDtos,LogDto.class,Log.class);
            number = logMapper.addLogs(logs);
        }
        return number;
    }

    public int addLogs(LogDto... logDtos) {
        List<LogDto> logDtoList = Arrays.asList(logDtos);
        return this.addLogs(logDtoList);
    }
}

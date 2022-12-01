package com.ferrum.hjtown.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ferrum.hjtown.bean.model.EventLog;
import com.ferrum.hjtown.mapper.EventLogMapper;
import com.ferrum.hjtown.service.EventLogService;
import org.springframework.stereotype.Service;

/**
 * @Auther: th
 * @CreateTime: 2022/12/1 16:31
 * @Description:
 */
@Service
public class EventLogServiceImpl extends ServiceImpl<EventLogMapper, EventLog> implements EventLogService {
}

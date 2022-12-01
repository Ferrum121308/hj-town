package com.ferrum.hjtown.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ferrum.hjtown.bean.common.RedisKey;
import com.ferrum.hjtown.bean.model.Event;
import com.ferrum.hjtown.bean.vo.UserInLineInfo;
import com.ferrum.hjtown.mapper.EventMapper;
import com.ferrum.hjtown.service.EventService;
import com.ferrum.hjtown.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: th
 * @CreateTime: 2022/12/1 16:29
 * @Description:
 */
@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements EventService {

	public static final List<String> colorStr = new ArrayList<>(Arrays.asList("RED","BLUE","GREEN","YELLOW","PURPLE"));

	@Autowired
	private RedisUtil redisUtil;

	@Override
	public UserInLineInfo getInLine(Long userId) {
		UserInLineInfo info = new UserInLineInfo();
		info.setUserId(userId);
		redisUtil.rightPush(RedisKey.ACTIVITY_QUEUE_NAME, userId);
		info.setIndex(redisUtil.keyIndex(RedisKey.ACTIVITY_QUEUE_NAME, userId));
		String color = colorStr.get(info.getIndex() % 5);
		info.setColor(color);
		return info;
	}
}

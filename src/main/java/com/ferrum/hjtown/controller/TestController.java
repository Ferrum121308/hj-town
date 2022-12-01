package com.ferrum.hjtown.controller;

import cn.hutool.core.util.RandomUtil;
import com.ferrum.hjtown.bean.common.RedisKey;
import com.ferrum.hjtown.bean.common.Result;
import com.ferrum.hjtown.bean.vo.UserInLineInfo;
import com.ferrum.hjtown.service.EventService;
import com.ferrum.hjtown.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: th
 * @CreateTime: 2022/12/1 15:17
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private EventService eventService;

	@GetMapping("/initColor")
	public void initColor(){
		List<String> colors = new ArrayList<>(Arrays.asList("RED","BLUE","GREEN","YELLOW","PURPLE"));
		for (String color : colors){
			redisUtil.rightPush(RedisKey.ACTIVITY_QUEUE_COLOR, color);
		}
	}

	@GetMapping("/testGetInLine")
	public Result<UserInLineInfo> testGetInLine(){
		Long userId = RandomUtil.randomLong();
		return Result.success(eventService.getInLine(userId));
	}

}

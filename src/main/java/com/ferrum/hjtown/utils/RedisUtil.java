package com.ferrum.hjtown.utils;

import com.ferrum.hjtown.bean.common.ResultCode;
import com.ferrum.hjtown.bean.exception.CustomException;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: th
 * @CreateTime: 2022/12/1 15:25
 * @Description:
 */
@Component
public class RedisUtil {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 读取缓存
	 *
	 * @param key
	 * @return
	 */
	public Object get(final String key) {
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * 写入缓存
	 */
	public boolean set(final String key, String value) {
		boolean result = false;
		try {
			redisTemplate.opsForValue().set(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 写入缓存,并设置过期时间
	 *
	 * @param key
	 * @param value
	 * @param timeout
	 * @param unit
	 * @return
	 */
	public boolean set(final String key, String value, long timeout, TimeUnit unit) {
		boolean result = false;
		try {
			redisTemplate.opsForValue().set(key, value, timeout, unit);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 更新缓存
	 */
	public boolean getAndSet(final String key, String value) {
		boolean result = false;
		try {
			redisTemplate.opsForValue().getAndSet(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 删除缓存
	 */
	public boolean delete(final String key) {
		boolean result = false;
		try {
			redisTemplate.delete(key);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 头部添加数据
	 */
	public boolean leftPush(final String key, final String value) {
		boolean result = false;
		try {
			redisTemplate.opsForList().leftPush(key, value);
		} catch (Exception e){
			throw new CustomException(ResultCode.ERROR);
		}
		return result;
	}

	/**
	 * 尾部添加数据
	 */
	public boolean rightPush(final String key, final Object value) {
		boolean result = false;
		try {
			redisTemplate.opsForList().rightPush(key, value);
		} catch (Exception e){
			throw new CustomException(ResultCode.ERROR);
		}
		return result;
	}

	/**
	 * 头部弹出数据
	 */
	public Object leftPop(final String queueName) {
		Object result;
		try {
			result = redisTemplate.opsForList().leftPop(queueName);
		} catch (Exception e){
			throw new CustomException(ResultCode.ERROR);
		}
		return result;
	}

	/**
	 * 获取位次
	 */
	public Integer keyIndex(final String queueName, final Object key){
		int index = -1;
		try {
			index = redisTemplate.opsForList().indexOf(queueName, key).intValue();
		} catch (Exception e){
			throw new CustomException(ResultCode.ERROR);
		}
		return index;
	}

}

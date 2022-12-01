package com.ferrum.hjtown.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ferrum.hjtown.bean.model.Event;
import com.ferrum.hjtown.bean.vo.UserInLineInfo;

/**
 * @Auther: th
 * @CreateTime: 2022/12/1 16:26
 * @Description:
 */
public interface EventService extends IService<Event> {

	UserInLineInfo getInLine(Long userId);

}

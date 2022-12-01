package com.ferrum.hjtown.bean.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Auther: th
 * @CreateTime: 2022/12/1 15:48
 * @Description: 抽奖事件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("hj_event")
public class Event {

	@TableId
	private Long eventId;
	private String eventName;
	private Integer totalAmount;
	private Integer leftAmount;
	private Date startTime;
	private Date endTime;
	private Date createTime;
	private Date updateTime;
	private Integer currentStatus;
	@TableLogic
	private Integer delStatus;

}

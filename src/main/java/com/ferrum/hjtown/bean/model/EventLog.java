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
 * @CreateTime: 2022/12/1 15:50
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("hj_event_log")
public class EventLog {

	@TableId
	private Long id;
	private Long userId;
	private Long eventId;
	private Integer jackpotStatus;
	private String exchangeCode;
	private Date createTime;
	private Integer checkStatus;
	@TableLogic
	private Integer delStatus;

}

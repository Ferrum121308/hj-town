package com.ferrum.hjtown.bean.vo;

import lombok.Data;

/**
 * @Auther: th
 * @CreateTime: 2022/10/27 18:24
 * @Description:
 */
@Data
public class JackpotResult {

	private Long eventId;
	private Long userId;
	private String exchangeCode;
	private Integer jackpotStatus;

}

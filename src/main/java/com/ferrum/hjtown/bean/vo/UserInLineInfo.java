package com.ferrum.hjtown.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: th
 * @CreateTime: 2022/12/1 17:48
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInLineInfo {

	private Long userId;
	private String color;
	private Integer index;

}

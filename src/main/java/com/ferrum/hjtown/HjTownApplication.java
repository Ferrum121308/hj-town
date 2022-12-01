package com.ferrum.hjtown;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ferrum.hjtown.mapper")
public class HjTownApplication {

	public static void main(String[] args) {
		SpringApplication.run(HjTownApplication.class, args);
	}

}

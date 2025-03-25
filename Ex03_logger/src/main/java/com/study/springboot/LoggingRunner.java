package com.study.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class LoggingRunner implements ApplicationRunner {
	/*
	 * Logger : 로그 메세지를 기록하기 위한 로거 인스턴스
	 	- logger변수에 현재 루트클래스의 logger 담기
	 	 1) Logger클래스 활용
	 	 2) LoggerFactory클래스 활용
	 	 3) LoggerFactory.getLogger(현재클래스이름.class)
	 */
	
	/* private static final*/Logger LOGGER = LoggerFactory.getLogger(LoggingRunner.class);
	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOGGER.trace("Trace레벨 로그");
		LOGGER.debug("Debug 레벨 로그");
		LOGGER.info("info 레벨 로그");
		LOGGER.warn("warn 레벨 로그");
		LOGGER.error("error 레벨 로그");
		

	}

}

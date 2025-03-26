package com.study.springboot.domain;

import lombok.Data;

@Data    //lombok타입으로 import하면 outline에 자동으로 getset 다 만들어짐
public class Board {
	private int boardno;
	private String title;
	private String writer;
	private String content;
}

package com.bean;

import lombok.Data;

@Data
public class SungJukDTO {
	private String name; 
	private int kor, eng, math, tot; 
	private double avg;
}

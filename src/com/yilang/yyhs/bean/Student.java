package com.yilang.yyhs.bean;

public class Student extends User {
	private int class_id;
	private String graduate_time;
	private int class_number;

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getGraduate_time() {
		return graduate_time;
	}

	public void setGraduate_time(String graduate_time) {
		this.graduate_time = graduate_time;
	}

	public int getClass_number() {
		return class_number;
	}

	public void setClass_number(int class_number) {
		this.class_number = class_number;
	}

}

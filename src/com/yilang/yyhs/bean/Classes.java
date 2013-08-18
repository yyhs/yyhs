package com.yilang.yyhs.bean;

import java.util.ArrayList;

public class Classes {
	private int class_id;
	private ArrayList<Integer> students;
	private ArrayList<Integer> teachers;
	private String graduate_time;
	private int head_teacher;
	private String description;
	private String logo;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public ArrayList<Integer> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Integer> students) {
		this.students = students;
	}

	public ArrayList<Integer> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<Integer> teachers) {
		this.teachers = teachers;
	}

	public String getGraduate_time() {
		return graduate_time;
	}

	public void setGraduate_time(String graduate_time) {
		this.graduate_time = graduate_time;
	}

	public int getHead_teacher() {
		return head_teacher;
	}

	public void setHead_teacher(int head_teacher) {
		this.head_teacher = head_teacher;
	}

}

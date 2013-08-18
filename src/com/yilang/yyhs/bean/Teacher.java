package com.yilang.yyhs.bean;

import java.util.ArrayList;

public class Teacher extends User {
	private ArrayList<Classes> classes;
	private String subject;

	public ArrayList<Classes> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<Classes> classes) {
		this.classes = classes;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}

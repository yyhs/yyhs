package com.yilang.yyhs.bean;

import java.util.ArrayList;

public class User {
	private int uid;
	private String name;
	private int age;
	private int sex;
	private int user_type;
	private ArrayList<User> friends;
	private String email;
	private int mobilephone;
	private String face;
	private String password;
	private String join_time;
	private String city;
	private String industry;
	private String job;
	private String company;
	private String hometown;  

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(int mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJoin_time() {
		return join_time;
	}

	public void setJoin_time(String join_time) {
		this.join_time = join_time;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public ArrayList<User> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}

}

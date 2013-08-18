package com.yilang.yyhs.bean;

import java.util.ArrayList;

public class Album {
	private int album_id;
	private String album_name;
	private String album_author;
	private ArrayList<Integer> owners;
	private String pubtime;
	private String description;
	private ArrayList<String> images;

	public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getAlbum_author() {
		return album_author;
	}

	public void setAlbum_author(String album_author) {
		this.album_author = album_author;
	}

	public ArrayList<Integer> getOwners() {
		return owners;
	}

	public void setOwners(ArrayList<Integer> owners) {
		this.owners = owners;
	}

	public String getPubtime() {
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

}

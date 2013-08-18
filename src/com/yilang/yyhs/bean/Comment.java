package com.yilang.yyhs.bean;

public class Comment {
	private int comment_id;
	private String content;
	private String author;
	private int author_id;
	private String pubtime;
	private int refer_id;

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getPubtime() {
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	public int getRefer_id() {
		return refer_id;
	}

	public void setRefer_id(int refer_id) {
		this.refer_id = refer_id;
	}

}

package com.yilang.yyhs.bean;

public class News {
	private int news_id;
	private String title;
	private String content;
	private int author_id;
	private String author_name;
	private String pubdate;

	public int getNews_id() {
		return news_id;
	}

	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

}

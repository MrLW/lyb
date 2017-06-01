package com.lw.lyb.bean;

public class MsgJson {

	private String title ;
	private Integer count = 0;
	
	public MsgJson() {
		super();
	}
	public MsgJson(String title, Integer count) {
		super();
		this.title = title;
		this.count = count;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "MsgJson [title=" + title + ", count=" + count + "]";
	} 
	
}

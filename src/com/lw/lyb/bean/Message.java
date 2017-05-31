package com.lw.lyb.bean;

import java.io.Serializable;
import java.util.Date;
/**
 *  ÁôÑÔÊµÌåBean
 * @author lw
 *
 */
public class Message implements Serializable{

	private Integer id ;
	private String title ;
	private String content; 
	private Date createTime ;
	private Integer sid;
	
	public Message() {
		super();
	}
	public Message(Integer id, String title, String content, Date createTime, Integer sid) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.sid = sid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + createTime
				+ ", sid=" + sid + "]";
	}
	
}

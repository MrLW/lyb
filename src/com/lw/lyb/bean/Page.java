package com.lw.lyb.bean;

import java.util.List;

/**
 * 分页对象
 * 
 * @author lw
 *
 */
public class Page {

	private Integer totalPages; // 总页数

	private int totalCount;// 总记录数

	private Integer curPage = 1 ; // 当前页,默认为第一页

	private Integer curCount = 5 ;// 每页显示记录数
	
	private List<Message> messages ;

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}


	public Integer getCurCount() {
		return curCount;
	}

	public void setCurCount(Integer curCount) {
		this.curCount = curCount;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "Page [totalPages=" + totalPages + ", totalCount=" + totalCount + ", curPage=" + curPage + ", curCount="
				+ curCount + ", messages=" + messages + "]";
	}

	

	
}

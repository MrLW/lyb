package com.lw.lyb.bean;

import java.util.List;

/**
 * ��ҳ����
 * 
 * @author lw
 *
 */
public class Page {

	private Integer totalPages; // ��ҳ��

	private int totalCount;// �ܼ�¼��

	private Integer curPage = 1 ; // ��ǰҳ,Ĭ��Ϊ��һҳ

	private Integer curCount = 5 ;// ÿҳ��ʾ��¼��
	
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

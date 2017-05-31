package com.lw.lyb.service;

import java.util.List;

import org.junit.Test;

import com.lw.lyb.bean.Message;
import com.lw.lyb.bean.Page;

public interface MessageService {

	void addMessage(Message message);

	void deleteMessageById(Integer id);

	void updateMessage(Message message);
	/**
	 *  查询消息列表
	 * @return 消息集合
	 */
	List<Message> getMessageList() ;
	
	/**
	 *  分页显示消息对象
	 * @return
	 */
	Page getPage(int pageNo) ;

}
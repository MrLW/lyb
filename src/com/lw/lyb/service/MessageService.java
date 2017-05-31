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
	 *  ��ѯ��Ϣ�б�
	 * @return ��Ϣ����
	 */
	List<Message> getMessageList() ;
	
	/**
	 *  ��ҳ��ʾ��Ϣ����
	 * @return
	 */
	Page getPage(int pageNo) ;

}
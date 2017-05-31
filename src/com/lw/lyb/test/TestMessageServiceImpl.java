package com.lw.lyb.test;

import java.util.List;

import org.junit.Test;

import com.lw.lyb.bean.Message;
import com.lw.lyb.dao.MessageDao;
import com.lw.lyb.dao.impl.MessageDaoImpl;

public class TestMessageServiceImpl {

	MessageDao messageDao = new MessageDaoImpl();
	
	@Test
	public void testMessageService(){
		List<Message> messageList = messageDao.getMessageList();
		System.out.println(messageList);
	}
}

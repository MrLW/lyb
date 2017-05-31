package com.lw.lyb.service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lw.lyb.bean.Message;
import com.lw.lyb.bean.Page;
import com.lw.lyb.bean.Student;
import com.lw.lyb.dao.MessageDao;
import com.lw.lyb.dao.StudentDao;
import com.lw.lyb.dao.impl.MessageDaoImpl;
import com.lw.lyb.dao.impl.StudentDaoImpl;
import com.lw.lyb.service.MessageService;
import com.lw.lyb.service.StudentService;

/**
 * 学生service
 * 
 * @author lw
 *
 */
public class MessageServiceImpl implements MessageService {

	private MessageDao messageDao = new MessageDaoImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lw.lyb.service.impl.MessageService#addMessage(com.lw.lyb.bean.
	 * Message)
	 */
	@Override
	@Test
	public void addMessage(Message message) {
		messageDao.insert(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lw.lyb.service.impl.MessageService#deleteMessageById(java.lang.
	 * Integer)
	 */
	@Override
	public void deleteMessageById(Integer id) {
		messageDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lw.lyb.service.impl.MessageService#updateMessage(com.lw.lyb.bean.
	 * Message)
	 */
	@Override
	public void updateMessage(Message message) {
		messageDao.update(message);
	}

	@Test
	public List<Message> getMessageList() {
		List<Message> messageList = messageDao.getMessageList();
		System.out.println(messageList);
		return messageDao.getMessageList();
	}

	@Override
	public Page getPage(int pageNo) {
		Page page = new Page();
		System.out.println("当前页：" + pageNo);
		page.setCurPage(pageNo); // 设置当前页
		// 设置分页查询条件
		int limit = page.getCurCount();
		int start = (pageNo - 1) * limit;
		List<Message> messages = messageDao.getMessagesByPage(start, limit);
		int allCount = getMessageList().size();
		
		int totalPages = allCount % page.getCurCount() == 0 ?  allCount / page.getCurCount() : ( allCount / page.getCurCount() + 1 ) ;
		
		page.setMessages(messages);
		page.setTotalPages(totalPages);
		page.setTotalCount(allCount);
		
		// 查询总记录数
		return page;
	}

}

package com.lw.lyb.dao;

import java.util.List;

import com.lw.lyb.bean.Message;

public interface MessageDao {

	/**
	 *  添加一条留言
	 * @param message 留言对象
	 */
	void insert(Message message);

	/**
	 *  根据ID删除一条消息
	 * @param id
	 */
	void deleteById(Integer id);

	/**
	 *  修改一条消息
	 * @param message
	 */
	void update(Message message);

	/**
	 *  获取所有留言消息
	 */
	List<Message> getMessageList();

	/**
	 *  分页查询消息
	 * @param start
	 * @param limit
	 * @return
	 */
	List<Message> getMessagesByPage(int start, int limit);

}
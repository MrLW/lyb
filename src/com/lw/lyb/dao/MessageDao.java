package com.lw.lyb.dao;

import java.util.List;

import com.lw.lyb.bean.Message;

public interface MessageDao {

	/**
	 *  ���һ������
	 * @param message ���Զ���
	 */
	void insert(Message message);

	/**
	 *  ����IDɾ��һ����Ϣ
	 * @param id
	 */
	void deleteById(Integer id);

	/**
	 *  �޸�һ����Ϣ
	 * @param message
	 */
	void update(Message message);

	/**
	 *  ��ȡ����������Ϣ
	 */
	List<Message> getMessageList();

	/**
	 *  ��ҳ��ѯ��Ϣ
	 * @param start
	 * @param limit
	 * @return
	 */
	List<Message> getMessagesByPage(int start, int limit);

}
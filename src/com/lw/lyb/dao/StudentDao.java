package com.lw.lyb.dao;

import com.lw.lyb.bean.Student;

public interface StudentDao {

	/**
	 * ���ѧ��
	 * 
	 * @param student ѧ������
	 *           
	 */
	void insert(Student student);
	
	/**
	 *  �����û��������ѯ�û�
	 * @param username �û���
	 * @param passsword ����
	 * @return
	 */
	Student selectByUserNameAndPassWord(String username,String passsword);

}
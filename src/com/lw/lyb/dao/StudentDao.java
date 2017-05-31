package com.lw.lyb.dao;

import com.lw.lyb.bean.Student;

public interface StudentDao {

	/**
	 * 添加学生
	 * 
	 * @param student 学生对象
	 *           
	 */
	void insert(Student student);
	
	/**
	 *  根据用户名密码查询用户
	 * @param username 用户名
	 * @param passsword 密码
	 * @return
	 */
	Student selectByUserNameAndPassWord(String username,String passsword);

}
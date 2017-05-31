package com.lw.lyb.service.impl;

import org.junit.Test;

import com.lw.lyb.bean.Student;
import com.lw.lyb.dao.StudentDao;
import com.lw.lyb.dao.impl.StudentDaoImpl;
import com.lw.lyb.service.StudentService;

/**
 * Ñ§Éúservice
 * 
 * @author lw
 *
 */
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao = new StudentDaoImpl();

	/* (non-Javadoc)
	 * @see com.lw.lyb.service.StudentService#add()
	 */
	@Override
	@Test
	public void register(Student student) {
		studentDao.insert(student);
	}
	
	/* (non-Javadoc)
	 * @see com.lw.lyb.service.StudentService#findByUserNameAndPassWord()
	 */
	@Override
	@Test
	public Student findByUserNameAndPassWord(String username,String password){
		Student student = studentDao.selectByUserNameAndPassWord(username, password);
		return student ; 
	}
	
}

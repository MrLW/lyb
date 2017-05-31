package com.lw.lyb.service;

import org.junit.Test;

import com.lw.lyb.bean.Student;

public interface StudentService {

	void register(Student student);

	Student findByUserNameAndPassWord(String username,String password);

}
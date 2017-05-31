package com.lw.lyb.servlet;

import javax.servlet.http.HttpServlet;

import com.lw.lyb.service.StudentService;
import com.lw.lyb.service.impl.StudentServiceImpl;

public class BaseServlet extends HttpServlet{

	protected StudentService studentService = new StudentServiceImpl();
	
	
}

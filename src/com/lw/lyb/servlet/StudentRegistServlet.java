package com.lw.lyb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lw.lyb.bean.Student;
import com.lw.lyb.service.StudentService;
import com.lw.lyb.service.impl.StudentServiceImpl;

public class StudentRegistServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	

	public StudentRegistServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		// 2、封装student对象
		Student student = new Student(username,password,Integer.parseInt(type));
		System.out.println("注册:" + student);
		// 3、注册
		studentService.register(student);
		// 4、存入session并且回到主页
		response.setContentType("text/html,Charset=UTF-8");
		request.getSession().setAttribute("student", student);
		response.sendRedirect(this.getServletContext().getContextPath() + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

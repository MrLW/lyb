package com.lw.lyb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lw.lyb.bean.Message;
import com.lw.lyb.bean.Student;
import com.lw.lyb.service.MessageService;
import com.lw.lyb.service.StudentService;
import com.lw.lyb.service.impl.MessageServiceImpl;
import com.lw.lyb.service.impl.StudentServiceImpl;

/**
 * 注册servlet
 */
public class StudentLoginServlet extends BaseServlet {

	

	public StudentLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Student student = studentService.findByUserNameAndPassWord(username, password);
		if (student != null) {
			// 登录成功,将当前信息存入session
			request.getSession().setAttribute("student", student);
			// 清除未登陆信息
			request.getSession().removeAttribute("noLogin");
			// 重定向到index.jsp
			//System.out.println("1:" + this.getServletContext().getContextPath()); 当前项目路径
			//System.out.println("2:" + this.getServletContext().getRealPath("/")); 真实当前硬盘路径
			
			response.sendRedirect(this.getServletContext().getContextPath() + "/IndexServlet");
		}else {
			// 登录失败,将错误信息存入session
			request.getSession().setAttribute("error", "用户名/密码不正确");
			response.sendRedirect(this.getServletContext().getContextPath() + "/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

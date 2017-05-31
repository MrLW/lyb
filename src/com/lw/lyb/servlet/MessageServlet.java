package com.lw.lyb.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lw.lyb.bean.Message;
import com.lw.lyb.bean.Student;
import com.lw.lyb.service.MessageService;
import com.lw.lyb.service.impl.MessageServiceImpl;

/**
 * Servlet implementation class MessageServlet
 */
public class MessageServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private MessageService messageService = new MessageServiceImpl();

	public MessageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 获取curd操作
		String oprParam = request.getParameter("operator");
		Integer operator = Integer.parseInt(oprParam);
		// 删除ID
		String deleteId = request.getParameter("deleteId");
		
		System.out.println(operator.equals("delete"));
		if(operator == 1 ){ // 删除消息
			messageService.deleteMessageById(Integer.parseInt(deleteId));
			// 重定向到index
			response.sendRedirect(this.getServletContext().getContextPath() + "/IndexServlet");
		} else if(operator == 2 ){ // 添加消息
			// 获取当前学生对象
			Student student = (Student) request.getSession().getAttribute("student");
			
			if(student == null){
				//当前未登陆,不能留言
				request.getSession().setAttribute("noLogin", "没有登陆,不能留言");
				response.sendRedirect(this.getServletContext().getContextPath() + "/index.jsp");
				return ;
			}
			
			// 创建消息对象
			Message msg = new Message();
			msg.setContent(content);
			msg.setTitle(title);
			msg.setSid(student.getId());
			msg.setCreateTime(new Date());
			
			messageService.addMessage(msg);
			// 重定向到主页
			response.sendRedirect(this.getServletContext().getContextPath() + "/IndexServlet");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.lw.lyb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lw.lyb.bean.Message;
import com.lw.lyb.bean.Page;
import com.lw.lyb.service.MessageService;
import com.lw.lyb.service.impl.MessageServiceImpl;

/**
 * 主页Servlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageService messageService = new MessageServiceImpl();

	public IndexServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int curPage = 1 ;
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		} catch (Exception e) {
			curPage = 1 ;
		}
		// 查询所有留言信息
		List<Message> messageList = messageService.getMessageList();
		request.getSession().setAttribute("messageList", messageList);
		
		// 分页查询
		Page page = messageService.getPage(curPage);
		
		request.getSession().setAttribute("page", page);
		
		response.sendRedirect(this.getServletContext().getContextPath() + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

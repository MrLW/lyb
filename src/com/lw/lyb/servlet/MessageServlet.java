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
		// ��ȡcurd����
		String oprParam = request.getParameter("operator");
		Integer operator = Integer.parseInt(oprParam);
		// ɾ��ID
		String deleteId = request.getParameter("deleteId");
		
		System.out.println(operator.equals("delete"));
		if(operator == 1 ){ // ɾ����Ϣ
			messageService.deleteMessageById(Integer.parseInt(deleteId));
			// �ض���index
			response.sendRedirect(this.getServletContext().getContextPath() + "/IndexServlet");
		} else if(operator == 2 ){ // �����Ϣ
			// ��ȡ��ǰѧ������
			Student student = (Student) request.getSession().getAttribute("student");
			
			if(student == null){
				//��ǰδ��½,��������
				request.getSession().setAttribute("noLogin", "û�е�½,��������");
				response.sendRedirect(this.getServletContext().getContextPath() + "/index.jsp");
				return ;
			}
			
			// ������Ϣ����
			Message msg = new Message();
			msg.setContent(content);
			msg.setTitle(title);
			msg.setSid(student.getId());
			msg.setCreateTime(new Date());
			
			messageService.addMessage(msg);
			// �ض�����ҳ
			response.sendRedirect(this.getServletContext().getContextPath() + "/IndexServlet");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

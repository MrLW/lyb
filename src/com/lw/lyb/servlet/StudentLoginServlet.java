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
 * ע��servlet
 */
public class StudentLoginServlet extends BaseServlet {

	

	public StudentLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1����ȡ�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Student student = studentService.findByUserNameAndPassWord(username, password);
		if (student != null) {
			// ��¼�ɹ�,����ǰ��Ϣ����session
			request.getSession().setAttribute("student", student);
			// ���δ��½��Ϣ
			request.getSession().removeAttribute("noLogin");
			// �ض���index.jsp
			//System.out.println("1:" + this.getServletContext().getContextPath()); ��ǰ��Ŀ·��
			//System.out.println("2:" + this.getServletContext().getRealPath("/")); ��ʵ��ǰӲ��·��
			
			response.sendRedirect(this.getServletContext().getContextPath() + "/IndexServlet");
		}else {
			// ��¼ʧ��,��������Ϣ����session
			request.getSession().setAttribute("error", "�û���/���벻��ȷ");
			response.sendRedirect(this.getServletContext().getContextPath() + "/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.lw.lyb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	

	private HttpSession session;

	public StudentLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1����ȡ�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Student student = studentService.findByUserNameAndPassWord(username, password);
		session = request.getSession();
		if (student != null) {
			// ��¼�ɹ�,����ǰ��Ϣ����session
			session.setAttribute("student", student);
			// ���δ��½��Ϣ
			if(session.getAttribute("noLogin") != null ){
				session.removeAttribute("noLogin");
			}
			// �ض���index.jsp
			//System.out.println("1:" + this.getServletContext().getContextPath()); ��ǰ��Ŀ·��
			//System.out.println("2:" + this.getServletContext().getRealPath("/")); ��ʵ��ǰӲ��·��
			
			response.sendRedirect(this.getServletContext().getContextPath() + "/IndexServlet");
		}else {
			// ��¼ʧ��,��������Ϣ����session
			session.setAttribute("error", "�û���/���벻��ȷ");
			response.sendRedirect(this.getServletContext().getContextPath() + "/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

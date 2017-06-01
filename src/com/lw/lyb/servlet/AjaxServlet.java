package com.lw.lyb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.lw.lyb.bean.Message;
import com.lw.lyb.bean.MsgJson;
import com.lw.lyb.bean.TitlePojo;
import com.lw.lyb.service.MessageService;
import com.lw.lyb.service.TitleService;
import com.lw.lyb.service.impl.MessageServiceImpl;
import com.lw.lyb.service.impl.TitleServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TitleService titleService = new TitleServiceImpl();

	public AjaxServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oper = request.getParameter("operator");

		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");

		List<TitlePojo> titlePojos = titleService.getAllTitles();

		Object json = com.alibaba.fastjson.JSONArray.toJSON(titlePojos);
		System.out.println("json:" + json);

		if ("title".equals(oper)) { // 统计标题记录
			response.getWriter().print(json);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

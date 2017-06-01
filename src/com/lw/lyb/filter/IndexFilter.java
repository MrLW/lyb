package com.lw.lyb.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lw.lyb.bean.Message;
import com.lw.lyb.bean.Page;
import com.lw.lyb.bean.TitlePojo;
import com.lw.lyb.service.MessageService;
import com.lw.lyb.service.TitleService;
import com.lw.lyb.service.impl.MessageServiceImpl;
import com.lw.lyb.service.impl.TitleServiceImpl;

public class IndexFilter implements Filter {

	private MessageService messageService = new MessageServiceImpl();

	private TitleService titleService = new TitleServiceImpl();
	

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		// 查询所有留言信息
		List<Message> messageList = messageService.getMessageList();
		request.getSession().setAttribute("messageList", messageList);

		// 查询所有标题
		List<TitlePojo> allTitles = titleService.getAllTitles();
		request.getSession().setAttribute("titleList", allTitles);
		System.out.println("titles:" + allTitles);
		
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

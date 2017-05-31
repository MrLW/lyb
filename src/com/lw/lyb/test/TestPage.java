package com.lw.lyb.test;

import com.lw.lyb.bean.Page;
import com.lw.lyb.service.MessageService;
import com.lw.lyb.service.impl.MessageServiceImpl;

public class TestPage {

	public static void main(String[] args) {
		MessageService messageService = new MessageServiceImpl() ;
		Page page = messageService.getPage(2);
		System.out.println(page);
	}
}

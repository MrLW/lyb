package com.lw.lyb.test;

import java.util.List;

import com.lw.lyb.bean.TitlePojo;
import com.lw.lyb.service.TitleService;
import com.lw.lyb.service.impl.TitleServiceImpl;

public class TestTitle {

	private static Integer count;

	public static void main(String[] args) {
		TitleService titleService = new TitleServiceImpl();
//		count = titleService.getCountByTitleName("∂¡ È");
//		System.out.println("count1:" + count);
//		count++;
//		titleService.addCountByName("∂¡ È", count);
//		count = titleService.getCountByTitleName("∂¡ È");
//		System.out.println("count2:" + count);
		List<TitlePojo> allTitles = titleService.getAllTitles();
		System.out.println(allTitles);
	}
}

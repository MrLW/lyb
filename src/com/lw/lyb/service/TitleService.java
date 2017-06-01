package com.lw.lyb.service;

import java.util.List;

import com.lw.lyb.bean.TitlePojo;

public interface TitleService {

	List<TitlePojo> getAllTitles();
	
	void addCountByName(String name,Integer count);

	Integer getCountByTitleName(String title);

	List<TitlePojo> getTitleList();

}
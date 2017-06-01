package com.lw.lyb.dao;

import java.util.List;

import com.lw.lyb.bean.TitlePojo;

public interface TitleDao {

	/**
	 * 查询所有标题
	 * 
	 * @return
	 */
	List<TitlePojo> select();


	void addCountByName(String name,Integer count);


	Integer getCountByTitleName(String title);


	List<TitlePojo> getTitleList();
}
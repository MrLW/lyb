package com.lw.lyb.dao;

import java.util.List;

import com.lw.lyb.bean.TitlePojo;

public interface TitleDao {

	/**
	 * ��ѯ���б���
	 * 
	 * @return
	 */
	List<TitlePojo> select();


	void addCountByName(String name,Integer count);


	Integer getCountByTitleName(String title);


	List<TitlePojo> getTitleList();
}
package com.lw.lyb.service.impl;

import java.util.List;

import com.lw.lyb.bean.TitlePojo;
import com.lw.lyb.dao.TitleDao;
import com.lw.lyb.dao.impl.TitleDaoImpl;
import com.lw.lyb.service.TitleService;

public class TitleServiceImpl implements TitleService {

	private TitleDao titleDao = new TitleDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.lw.lyb.service.impl.TitleService#getAllTitles()
	 */
	@Override
	public List<TitlePojo> getAllTitles(){
		List<TitlePojo> list = titleDao.select();
		return list; 
	}
	
	public void addCountByName(String name,Integer count){
		titleDao.addCountByName(name,count);
	}

	@Override
	public Integer getCountByTitleName(String title) {
		return titleDao.getCountByTitleName(title);
	}

	@Override
	public List<TitlePojo> getTitleList() {
		// TODO Auto-generated method stub
		return titleDao.getTitleList();
	}
}

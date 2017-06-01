package com.lw.lyb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.lw.lyb.bean.Student;
import com.lw.lyb.bean.TitlePojo;
import com.lw.lyb.dao.TitleDao;
import com.lw.lyb.utils.JdbcUtil;

public class TitleDaoImpl implements TitleDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lw.lyb.dao.impl.TitleDao#select()
	 */
	@Override
	public List<TitlePojo> select() {

		List<TitlePojo> list = null;
		try {
			// 1、创建runner对象
			QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "SELECT * FROM TITLE ";
			list = runner.query(sql, new BeanListHandler<>(TitlePojo.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(JdbcUtil.getConnection());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void addCountByName(String name, Integer count) {

		try {
			// 1、创建runner对象
			QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "update title set count =  ?  where name = ? ";
			runner.update(sql, count, name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(JdbcUtil.getConnection());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Integer getCountByTitleName(String name) {
		Integer count = 0;

		try {
			// 1、创建runner对象
			QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "SELECT count FROM TITLE where name = ? ";
			List<Object> list = runner.query(sql, new ColumnListHandler<>(1),name);
			count = (Integer) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(JdbcUtil.getConnection());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;
	}

	@Override
	public List<TitlePojo> getTitleList() {
		List<TitlePojo> list = null ;

		try {
			// 1、创建runner对象
			QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "SELECT count FROM TITLE ";
			list = runner.query(sql, new BeanListHandler<>(TitlePojo.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(JdbcUtil.getConnection());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}

package com.lw.lyb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lw.lyb.bean.Message;
import com.lw.lyb.bean.Student;
import com.lw.lyb.dao.MessageDao;
import com.lw.lyb.utils.JdbcUtil;

/**
 * 留言Dao
 * 
 * @author lw
 *
 */
public class MessageDaoImpl implements MessageDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lw.lyb.dao.impl.MessageDao#insert(com.lw.lyb.bean.Message)
	 */
	@Override
	public void insert(Message message) {
		QueryRunner runner = null;
		try {
			// 1、创建runner对象
			runner = new QueryRunner(JdbcUtil.getDataSource());
			// 2、创建sql
			String sql = "insert into ly values(null,?,?,?,?)";
			// 3、执行insert
			Object insertObj = runner.insert(sql, new BeanHandler<>(Message.class), message.getTitle(),
					message.getContent(), message.getCreateTime(), message.getSid());

			System.out.println(insertObj);

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
	public void deleteById(Integer id) {
		QueryRunner runner = null;
		try {
			// 1、创建runner对象
			runner = new QueryRunner(JdbcUtil.getDataSource());
			// 2、创建sql
			String sql = "delete from ly where id = ? ";
			runner.update(sql, id);
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
	public void update(Message message) {

		QueryRunner runner = null;
		try {
			// 1、创建runner对象
			runner = new QueryRunner(JdbcUtil.getDataSource());
			// 2、创建sql
			String sql = "update table ly set title = ? , content = ? , createTime = ? where id = ? ";
			runner.update(sql, message.getTitle(),message.getContent(),message.getCreateTime(),message.getId());
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
	public List<Message> getMessageList() {
		List<Message> messageList = null ;
		QueryRunner runner = null;
		try {
			// 1、创建runner对象
			runner = new QueryRunner(JdbcUtil.getDataSource());
			// 2、创建sql
			String sql = "select * from ly";
			messageList = runner.query(sql, new BeanListHandler<>(Message.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(JdbcUtil.getConnection());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return messageList ;
	}

	@Override
	public List<Message> getMessagesByPage(int start, int limit) {
		List<Message> messageList = null ;
		QueryRunner runner = null;
		try {
			// 1、创建runner对象
			runner = new QueryRunner(JdbcUtil.getDataSource());
			// 2、创建sql
			String sql = "select * from ly limit ? , ? ";
			messageList = runner.query(sql, new BeanListHandler<>(Message.class),start,limit);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(JdbcUtil.getConnection());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return messageList ;
	}
}

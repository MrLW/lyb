package com.lw.lyb.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lw.lyb.bean.Student;
import com.lw.lyb.dao.StudentDao;
import com.lw.lyb.utils.JdbcUtil;
import com.mchange.v2.c3p0.impl.DbAuth;

public class StudentDaoImpl implements StudentDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lw.lyb.dao.StudentDao#insert(com.lw.lyb.bean.Student)
	 */
	@Override
	public void insert(Student student) {
		QueryRunner runner = null;
		try {
			// 1、创建runner对象
			runner = new QueryRunner(JdbcUtil.getDataSource());
			// 2、创建sql
			String sql = "insert into student values(null,?,?,?)";
			// 3、执行insert
			Object insertObj = runner.insert(sql, new BeanHandler<>(Student.class), student.getUsername(), student.getPassword(),
					student.getType());

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
	public Student selectByUserNameAndPassWord(String username, String passsword) {

		Student student = null;
		try {
			// 1、创建runner对象
			QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "SELECT * FROM STUDENT WHERE USERNAME = ? AND PASSWORD = ? ";
			student = runner.query(sql, new BeanHandler<>(Student.class), username, passsword);
			System.out.println("query:" + student);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(JdbcUtil.getConnection());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}
}

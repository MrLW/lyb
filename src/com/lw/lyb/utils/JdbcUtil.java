package com.lw.lyb.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {

	// ��ȡc3p0���ӳ�
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource() ;
	

   /**
    * ������ݿ����Ӷ���
    *
    * @return
    * @throws SQLException
    */
   public static Connection getConnection() throws SQLException {
       return dataSource.getConnection();
   }
   
   public static DataSource getDataSource(){
	   return dataSource ;
   }
}

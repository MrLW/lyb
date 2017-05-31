package com.lw.lyb.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {

	// 获取c3p0连接池
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource() ;
	

   /**
    * 获得数据库连接对象
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

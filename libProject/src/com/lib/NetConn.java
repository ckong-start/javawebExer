package com.lib;

//连接数据库

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// 数据库联接类
public class NetConn {
	Connection con;
	Statement sql;

	public Statement connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// 载入驱动程序字符串
		} catch (ClassNotFoundException e1) {
		}
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=liber_db", "sa", "123");// 通过JDBC
																													// URL得到Connection对象
			sql = con.createStatement();// 通过Connection对象创建Statement对象
		} catch (SQLException e2) {
		}
		return sql;
	}
}

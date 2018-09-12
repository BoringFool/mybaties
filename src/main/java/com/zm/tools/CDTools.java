package com.zm.tools;

import com.mysql.jdbc.Connection;
import java.lang.Class;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CDTools {
	private static final String URL = "jdbc:mysql:///mybaties?useUnicode=true&amp;characterEncoding=utf-8";
	private static final String USER = "root";
	private static final String PASSWORD = "804998";

	private static Connection conn = null;

	static {
		try {
			// 1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获得数据库的连接
			conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 将获得的数据库与java的链接返回（返回的类型为Connection）
	public static Connection getConnection() {
		return conn;
	}

}

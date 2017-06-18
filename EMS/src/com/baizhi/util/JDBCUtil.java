package com.baizhi.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

	private static Properties p = new Properties();
	static {
		InputStream is = JDBCUtil.class.getResourceAsStream("/jdbc.properties");
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	public static Connection getConnection() {
		Connection conn = tl.get();
		if (conn == null) {
			try {
				Class.forName(p.getProperty("driver"));
				conn = DriverManager.getConnection(p.getProperty("url"),
						p.getProperty("username"), p.getProperty("password"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			tl.set(conn);
			return conn;
		} else {
			return conn;
		}
	}

	public static void close(Connection conn, PreparedStatement pst,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (pst != null) {
			try {
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
				tl.remove();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection conn, PreparedStatement pst) {
		if (pst != null) {
			try {
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
				tl.remove();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				tl.remove();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pst) {
		if (pst != null) {
			try {
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

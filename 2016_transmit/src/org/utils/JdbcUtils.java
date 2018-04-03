package org.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import oracle.sql.CLOB;

import org.apache.log4j.Logger;

public class JdbcUtils {
	private static final Logger logger = Logger.getLogger(JdbcUtils.class);

	private static String properties_name = "jdbc.properties";
	private static String URL = PropertiesUtil.getDefineKeyValue(
			properties_name, "url");
	private static String USERNAME = PropertiesUtil.getDefineKeyValue(
			properties_name, "username");
	private static String PASSWORD = PropertiesUtil.getDefineKeyValue(
			properties_name, "password");
	private static String DRIVER = PropertiesUtil.getDefineKeyValue(
			properties_name, "driverName");

	// Constructor
	public JdbcUtils() {
	}

	private static Connection getConnection() {
		java.sql.Connection con = null;
		try {
			Class.forName(DRIVER);
			con = java.sql.DriverManager.getConnection(URL, USERNAME, PASSWORD);
			if (con != null)
				System.out.println("Connection Successful!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Trace in getConnection() : "
					+ e.getMessage());
		}
		return con;
	}

	private static void closeConnection(ResultSet rs, Statement st,
			Connection conn) {
		logger.info("** JdbcUtils.closeConnection **");
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("数据关闭出错：" + e.getMessage());
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("数据关闭出错：" + e.getMessage());
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logger.error("数据关闭出错：" + e.getMessage());
					}
				}
			}
		}

	}

	public static ArrayList<?> executeSQL(String sql) {
		logger.info("** JdbcUtils.executeSQL.sql: " + sql);
		Connection con = JdbcUtils.getConnection();
		ArrayList<?> list = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			try {
				list = ResultSetToList(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(rs, ps, con);
		}
		return list;
	}

	public static void executeUpdateSQL(String sql) {
		logger.info("** JdbcUtils.executeUpdateSQL.sql: " + sql);
		Connection conn = JdbcUtils.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			int i = ps.executeUpdate();
			System.err.println("数据更新: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(rs, ps, conn);
		}

	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Map<Object, Object>> ResultSetToList(ResultSet rs)
			throws Exception {
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		ArrayList<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
		Map<Object, Object> rowData;
		while (rs.next()) {
			rowData = new HashMap(columnCount);
			for (int i = 1; i <= columnCount; i++) {
				Object v = rs.getObject(i);
				if (null != v && v.getClass() == CLOB.class) {
					v = clob2String((CLOB) v);
				}
				rowData.put(md.getColumnName(i).toLowerCase(), v);
			}
			list.add(rowData);
		}
		return list;
	}

	private static String clob2String(CLOB clob) throws Exception {
		return (clob != null ? clob.getSubString(1, (int) clob.length()) : null);
	}

	public static void main(String[] args) throws Exception {
		/*
		 * JdbcUtils myDbTest = new JdbcUtils(); myDbTest.displayDbProperties();
		 */
		// JdbcUtils.testSQL();
	}
}
package com.robert.book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDao {

	final int PAGE_SIZE = 10;

	private Connection connection;
	private Statement statement;
	private ResultSet rs;
	private String table = "books";

	public List<Map<String, Object>> getList(int cur_page) {
		int from = (cur_page - 1) * PAGE_SIZE;
		String sql = "select * from " + table + " limit " + from + "," +   PAGE_SIZE;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			connection = DbConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData(); // 获得结果集结构信息,元数据
			int columnCount = md.getColumnCount(); // 获得列数
			while (rs.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(rowData);

			}
			connection.close();
		} catch (SQLException e) {
			try {
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return list;
	}

	public static void main(String[] args) {
		BookDao dao = new BookDao();
		List<Map<String, Object>> list = dao.getList(1);
		for(Map<String, Object> obj: list) {
			System.out.println(obj.get("id"));
		}
//		System.out.println(list);
	}

}

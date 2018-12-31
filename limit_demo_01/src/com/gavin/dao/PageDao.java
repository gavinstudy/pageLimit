package com.gavin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gavin.entity.User;
import com.gavin.util.DBUtil;

public class PageDao extends DBUtil{
	public int getNoteCount() {
		String sql = "select count(*) from t_project";
		int count = 0;
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				count = rst.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				super.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public List<User> showNotesByPage(int page, int pageSize) {
		List<User> listNotes = new ArrayList<User>();
		String sql = "select id,name,description,createtime from t_project limit ?,?";
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page-1);
			pstmt.setInt(2, pageSize);
			rst = pstmt.executeQuery();
			while(rst.next()) {
				User user = new User();
				user.setId(rst.getString("id"));
				user.setName(rst.getString("name"));
				user.setDescription(rst.getString("description"));
				user.setCreatetime(rst.getString("createtime"));
				listNotes.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listNotes;
	}
	
}

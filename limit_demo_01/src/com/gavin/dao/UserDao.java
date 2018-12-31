package com.gavin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gavin.entity.User;
import com.gavin.util.DBUtil;

public class UserDao extends DBUtil{

	public List<User> selectList(){
		String sql = "select id,name,description,createtime from t_project";
		ArrayList<User> list = new ArrayList<User>();
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()) {
				User user = new User();
				user.setId(rst.getString("id"));
				user.setName(rst.getString("name"));
				user.setDescription(rst.getString("description"));
				user.setCreatetime(rst.getString("createtime"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				super.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}

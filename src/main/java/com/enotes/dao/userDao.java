package com.enotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.enotes.user.UserDetails;

public class userDao {
	private Connection conn;

	public userDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addUser(UserDetails user) {
		boolean result=false;
		try {
			String query="insert into user(name,email,password) values(?,?,?)";
					
			PreparedStatement pstm=conn.prepareStatement(query);
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getEmail());
			pstm.setString(3, user.getPassword());
			
			int i=pstm.executeUpdate();
			if(i==1) {
				result=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public UserDetails loginUser(UserDetails user) {
		UserDetails userDetails=null;
		try {
			String query="select * from user where email=? and password=?";
			PreparedStatement pstm =conn.prepareStatement(query);
			pstm.setString(1, user.getEmail());
			pstm.setString(2, user.getPassword());
			ResultSet rs=pstm.executeQuery();
			
			if(rs.next()) {
				userDetails=new UserDetails();
				userDetails.setId(rs.getInt("id"));
				userDetails.setName(rs.getString("name"));
				userDetails.setEmail(rs.getString("email"));
				userDetails.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDetails;
	}
}

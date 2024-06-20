package com.enotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.enotes.user.Post;
import com.enotes.user.UserDetails;

public class PostDao {
	private Connection conn;

	public PostDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public PostDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean addNotes(String title,String content,int uid) {
		boolean result=false;
		try {
			String query="insert into post(title,content,uid) values (?,?,?)";
			PreparedStatement pstm=conn.prepareStatement(query);
			pstm.setString(1, title);
			pstm.setString(2, content);
			pstm.setInt(3, uid);
			
			int i=pstm.executeUpdate();
			if(i==1) {
				result=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Post> getData(int id){
		Post p=null;
		ArrayList<Post> list = new ArrayList<Post>();
		try {
			String query="select * from post where uid=? order by id DESC";
			PreparedStatement pstm=conn.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()) {
				p=new Post();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
				p.setDate(rs.getTimestamp(4));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Post getdataById(int noteId) {
		Post post=null;
		try {
			String query="select * from post where id=?";
			PreparedStatement pstm=conn.prepareStatement(query);
			pstm.setInt(1, noteId);
			ResultSet rs=pstm.executeQuery();
			if(rs.next()) {
				post=new Post();
				post.setId(rs.getInt(1));
				post.setTitle(rs.getString(2));
				post.setContent(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}
	
	public boolean postUpdate(int nId,String t,String c) {
		boolean result=false;
		
		try {
			String query="update post set title=?,content=? where id=?";
			PreparedStatement pstm=conn.prepareStatement(query);
			pstm.setString(1, t);
			pstm.setString(2, c);
			pstm.setInt(3, nId);
			int i = pstm.executeUpdate();
			if(i==1) {
				result=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean deleteNote(int nId) {
		boolean result=false;
		
		try {
			String query="delete from post where id=?";
			PreparedStatement pstm=conn.prepareStatement(query);
			pstm.setInt(1, nId);
			int i = pstm.executeUpdate();
			if(i==1) {
				result=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}

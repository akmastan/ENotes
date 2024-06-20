package com.enotes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enotes.dao.PostDao;
import com.enotes.db.DBConnect;
import com.enotes.user.Post;

@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		PostDao dao=new PostDao(DBConnect.getConn());
		boolean result=dao.addNotes(title, content, uid);
		
		if(result) {
			System.out.println("Data inserted successfully");
			response.sendRedirect("showNotes.jsp");
		}else {
			System.out.println("Data not inserted");
		}
		
	}

}

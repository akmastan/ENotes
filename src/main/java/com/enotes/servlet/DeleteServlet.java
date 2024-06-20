package com.enotes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enotes.dao.PostDao;
import com.enotes.db.DBConnect;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int noteId=Integer.parseInt(request.getParameter("note_id"));
			PostDao dao=new PostDao(DBConnect.getConn());
			boolean i = dao.deleteNote(noteId);
			if(i) {
				
				HttpSession session=request.getSession();
				session.setAttribute("delete-msg", "Delete Successfully");
				response.sendRedirect("showNotes.jsp");
			}else {
				HttpSession session=request.getSession();
				session.setAttribute("wrong-msg", "Something went wrong on server");
				response.sendRedirect("showNotes.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}

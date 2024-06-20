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
import com.mysql.cj.Session;

@WebServlet("/EditNotesServlet")
public class EditNotesServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int noteId=Integer.parseInt(request.getParameter("nId"));
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			PostDao dao=new PostDao(DBConnect.getConn());
			boolean i = dao.postUpdate(noteId, title, content);
			if(i) {
				System.out.println("Data update successfully...");
				HttpSession session=request.getSession();
				session.setAttribute("update-msg", "Update data successfully");
				response.sendRedirect("showNotes.jsp");
			}else {
				System.out.println("Data not updated");
				response.sendRedirect("log");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

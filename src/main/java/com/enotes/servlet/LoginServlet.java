package com.enotes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enotes.dao.userDao;
import com.enotes.db.DBConnect;
import com.enotes.user.UserDetails;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		UserDetails user=new UserDetails();
		user.setEmail(email);
		user.setPassword(password);
		
		userDao dao=new userDao(DBConnect.getConn());
		UserDetails userDetails = dao.loginUser(user);
		
		if(userDetails!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("userD", userDetails);
			response.sendRedirect("home.jsp");
		}
		else {
			HttpSession session =request.getSession();
			session.setAttribute("login-failed", "Invaild Email Or Password");
			response.sendRedirect("login.jsp");
		}
	}

}

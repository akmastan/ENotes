package com.enotes.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enotes.dao.userDao;
import com.enotes.db.DBConnect;
import com.enotes.user.UserDetails;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException{
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("fname");
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		UserDetails user=new UserDetails();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		userDao dao=new userDao(DBConnect.getConn());
		boolean result=dao.addUser(user);
		
		HttpSession session;
		if(result) {
			session=request.getSession();
			session.setAttribute("reg-success", "Registration Successfully");
			response.sendRedirect("register.jsp");
		}else {
			session=request.getSession();
			session.setAttribute("failed-msg", "Something went wrong on server");
			response.sendRedirect("register.jsp");
		}
		
	}
}

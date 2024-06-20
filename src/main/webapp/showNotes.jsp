<%@page import="java.util.List"%>
<%@page import="com.enotes.db.DBConnect"%>
<%@page import="com.enotes.dao.PostDao"%>
<%@page import="com.enotes.user.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
UserDetails user3 = (UserDetails) session.getAttribute("userD");
if (user3 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error", "Please login...");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<%
	String updateMsg = (String) session.getAttribute("update-msg");
	if (updateMsg != null) {
	%>
	<div class="alert alert-success" role="alert"><%=updateMsg%></div>
	<%
	session.removeAttribute("update-msg");
	}
	%>
	<%
	String wrongMsg = (String) session.getAttribute("wrong-msg");
	if (wrongMsg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=wrongMsg%></div>
	<%
	session.removeAttribute("wrong-msg");
	}
	%>
	<%
	String deleteMsg = (String) session.getAttribute("delete-msg");
	if (deleteMsg != null) {
	%>
	<div class="alert alert-success" role="alert"><%=deleteMsg%></div>
	<%
	session.removeAttribute("delete-msg");
	}
	%>

	<div class="container">

		<h2 class="text-center">All Notes:</h2>


		<%
		if (user3 != null) {
			PostDao ob = new PostDao(DBConnect.getConn());
			List<Post> post = ob.getData(user.getId());
			for (Post p : post) {
		%>

		<div class="card mb-3">
			<div class="row">
				<div class="col-md-12">
					<div class="card-mt-3">
						<img alt="" src="img/img3.jpg"
							class="card-img-top mt-2 mx-auto d-block"
							style="max-width: 100px;">
						<div class="card-body p-4">

							<h5 class="card-title"><%=p.getTitle()%></h5>
							<p><%=p.getContent()%></p>
							<p>
								<b class="text-success">Published By:</b> <b
									class="text-primary"><%=user3.getName()%></b>
							</p>
							<p>
								<b class="text-success">Published Date:</b> <b
									class="text-primary"><%=p.getDate()%></b>
							</p>
							<div class="container text-center mt-2">
								<a href="DeleteServlet?note_id=<%=p.getId()%>"
									class="btn btn-danger">Delete</a> <a
									href="edit.jsp?note_id=<%=p.getId()%>" class="btn btn-primary">Edit</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<%
		}
		}

		%>


	</div>


</body>
</html>
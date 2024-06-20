<%@page import="com.enotes.db.DBConnect"%>
<%@page import="com.enotes.dao.PostDao"%>
<%@page import="com.enotes.user.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
UserDetails user4 = (UserDetails) session.getAttribute("userD");
if (user4 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error", "Please login...");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%
	int noteId = Integer.parseInt(request.getParameter("note_id"));
	PostDao postDao=new PostDao(DBConnect.getConn());
	Post p=postDao.getdataById(noteId);
	%>
	<div class="contaiber-fluid">
		<%@include file="all_component/navbar.jsp"%>
		<h1 class="text-center">Edit Your Notes</h1>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="EditNotesServlet" method="post">
						<input type="hidden" name="nId" value="<%=noteId%>">
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Enter
								Title</label> <input type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								name="title" value="<%=p.getTitle() %>" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1" class="form-label">Enter
								Content</label>

							<textarea rows="9" cols="" class="form-control" name="content"
								required="required"><%=p.getContent() %></textarea>
						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-primary my-3">Add
								Notes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>
</body>
</html>
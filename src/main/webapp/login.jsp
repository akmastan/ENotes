<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<%@include file="all_component/allcss.jsp"%>
<style>
.bg-custom {
	background: #8e24aa;
}

.div-color {
	background-image: linear-gradient(to right top, #05370a, #306314, #649019, #a2be17,
		#ebeb12);
	height: 500px;
}
</style>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fas fa-user-circle fa-3x"></i>
						<h4>Login Page</h4>
					</div>
					<%
					String invalidMsg = (String) session.getAttribute("login-failed");
					if (invalidMsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=invalidMsg%></div>
					<%
					session.removeAttribute("login-failed");
					}
					%>
					<%
					String withoutLogin=(String)session.getAttribute("login-error");
					if(withoutLogin!=null){
						%>
						<div class="alert alert-danger" role="alert"><%=withoutLogin%></div>
					<%
					session.removeAttribute("login-error");
					}
					%>
					<%
					String logoutMsg=(String)session.getAttribute("logout-msg");
					if(logoutMsg!=null){
						%>
						<div class="alert alert-success" role="alert"><%=logoutMsg%></div>
						<% 
						session.removeAttribute("logout-msg");
					}
					%>
					<div class="card-body">
						<form action="loginServlet" method="post">
							<div class="mb-3">
								<label>Enter Email</label> <input type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="uemail">

							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter
									Password</label> <input type="password" class="form-control"
									id="exampleInputPassword1" name="upassword">
							</div>


							<div class="d-grid">
								<button type="submit" class="btn btn-primary">Login</button>

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid bg-dark mt-1">
<p class="text-center text-white">Note : Design and developed by ak mastan</p>
<p class="text-center text-white">All Rights Reserved @akmastan-2024-25</p>
</div>
</body>
</html>
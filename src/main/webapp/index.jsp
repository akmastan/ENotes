<%@page import="java.sql.Connection"%>
<%@page import="com.enotes.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.back-img{
background: url('img/img1.png');
height: 80vh;
background-repeat: no-repeat;
background-size: cover;
}
</style>
<title>Home Page</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>

<%
Connection conn=DBConnect.getConn();
System.out.println(conn);
%>

<div class="container-fluid back-img">
<div class="text-center">
<h1 class="text-white"><i class="fas fa-book"></i>E Notes-Save Your Notes</h1>
<a href="login.jsp" class="btn btn-light"><i class="fas fa-user-circle"></i>Login</a>
<a href="register.jsp" class="btn btn-light"><i class="fas fa-user-plus"></i>Register</a>
</div>
</div>

<%@include file="all_component/footer.jsp" %>
</body>
</html>
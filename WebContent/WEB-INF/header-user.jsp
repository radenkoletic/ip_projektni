<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="isLogedIn" type="net.etfbl.movies.bean.UserBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/jquery-form.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
<link rel="stylesheet" href="resources/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<link rel="stylesheet" href="resources/css/font-awesome.min.css" />
<link rel="stylesheet" href="resources/css/font-awesome.css" />
<script type="text/javascript" src="resources/js/scripts.js"></script>
<script type="text/javascript"
	src="resources/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/scripts.js"></script>
</head>
<body>
	<div id="wrap">
		<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<a href="home" class="navbar-left"> <img class="logo"
				src="resources/images/movies.png">
			</a>
			<ul class="nav navbar-nav">
				<li><a href="home">Home</a></li>
				<% if (isLogedIn.getUser().isLogedIn()) { 
				if (isLogedIn.getUser().getUserType().equals("administrator")) {%>
				<li><a href="users">Users</a></li>
				<li><a href="genres">Genres</a></li>
				<% }} %>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><%= isLogedIn.getUser().getUsername() %> <%
							if (isLogedIn.getUser().getUserType().equals("administrator")) { %>(admin)
							<% } %>
							<span class="caret"></span></a>
					<ul class="dropdown-menu navbar-inverse navbar-nav">
						<li><a href="home?action=settings">Settings</a></li>
						<li><a href="guest?action=logout">Log out</a></li>
					</ul></li>
			</ul>
		</div>
		</nav>
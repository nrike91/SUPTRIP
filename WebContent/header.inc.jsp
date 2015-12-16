<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<div class="page-header">
<div class="container">
<nav class="nav  navbar-default">
<img class="HeadLogo" alt="logo" src="image/supinfo.png" >
<div class="container-fluid navbar-right">
<ul class="nav navbar-nav">
<li> <a href="${pageContext.request.contextPath}/IndexServlet">Home</a></li>

<li> <a href="${pageContext.request.contextPath}/ListTrip"> Liste Trip </a></li>
<% if(session.getAttribute("user") != null) { %>
<li class="active "> <a href="${pageContext.request.contextPath}/ListTripOfUser"> BAG </a></li>
<% }  %>

<li> <a href="${pageContext.request.contextPath}/ViewProfileServlet"> Profile </a></li>
<% if(session.getAttribute("user") == null) { %>
<li class="active "> <a href="${pageContext.request.contextPath}/auth/login.jsp"> Login </a></li>
<li> <a href="${pageContext.request.contextPath}/ViewRegisterServlet"> Register </a></li>
<% } else { %>
<li class="active "> <a href="${pageContext.request.contextPath}/logout"> Logout </a></li>
<% } %>


<form   class="navbar-form navbar-right inline-form" method="post" action="${pageContext.request.contextPath}/FindTrip">
<div class="form-group scroll">


<input type="search" name="search" class="input-sm form-control" paceholder="recherche">
<button type="submit" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-eye-open"></span>Chercher</button>

</div>

</ul>


</form>

</div>
<nav>
</p>


</div>
</div>


</body>
</html>
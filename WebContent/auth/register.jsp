<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="<%=application.getContextPath()%>/RegisterServlet">
		<label for="firstname">firstname : </label>
		<input id="firstname" name="firstname" /><br />
		
		<label for="lastname">lastname : </label>
		<input id="lastname" name="lastname" /><br />
		
		<label for="password">password: </label>
		<input id="password" name="password"  type="password"/><br />
		
		<label for="email">Email: </label>
		<input id="email" name="email" type="text" /><br />
		
		<label for="Campus">Campus: </label>
		
		<select name="Campus">
		<c:forEach items="${campus}" var="c">
		<option value="${c.getIdCampus()}">${c.getCampusName()}</option>
		</c:forEach>
		</select><br />
		<input type="submit" />
	</form>
	
</body>
</html>
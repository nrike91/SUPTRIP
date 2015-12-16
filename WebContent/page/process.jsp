<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/listtrip.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
     	<%@ include file="/header.inc.jsp" %>
     
        <div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
    <h1> Si vous êtes sûres votre action</br> cliquer sur terminer</h1>
      <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Date</th>
            <th class="text-center">Action</th>
        </tr>
    </thead>
    		
    	   
    	    <form action="<%=application.getContextPath() %>/RemoveTripInBagServlet" method="post">
    	
            <tr>
                <td>${c.getIdTrip() }</td>
                <td>${c.getDescription() }</td>
                <td>${c.getDate() } </td>
                <td class="text-center"><input type="submit" name="trip"  value="terminer"><span class="glyphicon glyphicon-edit"></span>   </td> 
                <input type="hidden" name="idTrip" value="${c.getIdTrip() }">     
            </tr>
            </form> 
          
              
          
    </table>
    </div>
</div>
   
      
</body>
</html>
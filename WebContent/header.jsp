<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<p>

<% if(session.getAttribute("username") != null) { %>
<a href="<%= application.getContextPath() %>/logout">Logout</a>
<% } else { %>
<a href="<%= application.getContextPath() %>/login">Login</a>
<a href="<%= application.getContextPath() %>">Register</a>
<% } %>
</p>
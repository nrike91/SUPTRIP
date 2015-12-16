<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/login.css" rel="stylesheet">

<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="../js/login.js"></script>

<title>Insert title here</title>
</head>
<body>
<div class="container">
  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      <section class="login-form">
        <form method="post" action="<%=application.getContextPath() %>/login" role="login">
          <img src="<%=application.getContextPath() %>/image/supinfo.png" class="img-responsive" alt="" />
          <input type="text" name="id" placeholder="Id" required class="form-control input-lg" />
          
          <input type="password" class="form-control input-lg" name="password" id="password" placeholder="Password" required="" />
          
          
          <div class="pwstrength_viewport_progress"></div>
          
          
          <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
          <div>
            <a href="<%=application.getContextPath() %>/RegisterServlet">Create account</a> or <a href="#">reset password</a>
          </div>
          
        </form>
        
      </section>  
      </div>
      
      <div class="col-md-4"></div>
      

  </div>
  
</div>
</body>
</html>
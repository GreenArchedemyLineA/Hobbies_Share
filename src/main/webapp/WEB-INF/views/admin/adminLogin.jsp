<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ut">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/admin.css">
</head>
<body>
	<div style="display: flex; width: 100%; height: 100%; justify-content:center; align-items: center;">
		<div class="login-wrapper">
	        <h2>Login</h2>
	        <form method="post" action="/admin/admin-proc" id="login-form">
	            <input type="email" name="email" placeholder="Email">
	            <input type="password" name="password" placeholder="Password">
	            <input type="submit" value="Login">
	        </form>
	    </div>
    </div>
    <script>
    	
    </script>
</body>
</html>
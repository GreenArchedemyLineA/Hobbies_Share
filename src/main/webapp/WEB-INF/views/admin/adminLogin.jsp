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
	<div class="login-wrapper">
        <h2>Login</h2>
        <form method="post" action="/admin/admin-proc" id="login-form">
            <input type="text" name="userName" placeholder="Email">
            <input type="password" name="userPassword" placeholder="Password">
            <label for="remember-check">
                <input type="checkbox" id="remember-check">아이디 저장하기
            </label>
            <input type="submit" value="Login">
        </form>
    </div>
    <script>
    	
    </script>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<title>로그인(Login)</title>
</head>
<body>
<h1>
	로그인 페이지
</h1>

<form method="POST" action="authorize">
	아이디:
	<input type="text" name="username" /><br/>
	비밀번호:
	<input type="text" name="passwd" /><br/>
	<input type="submit" value="전송" />
</form>


</body>
</html>

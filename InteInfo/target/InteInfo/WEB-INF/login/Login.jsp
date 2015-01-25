<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../shared/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/login/login.css" rel="stylesheet"
	type="text/css" />

<title>Login</title>
</head>
<body>

	<form id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/Login/loginAction!doNotNeedSession_LoginResult.action">
		<h1>Log In</h1>
		<fieldset id="inputs">
			<input id="staffid" name="staffid" type="text" placeholder="Username"
				autofocus="autofocus" required="required">			
		<input id="userpassword"
				name="userpassword" type="password" placeholder="Password">
		</fieldset>
		<fieldset id="actions">
			<input type="submit" id="submit" value="Log in"/>
			<span><font size = '2' color = 'red'><s:property value="returnLoginMessage"/></font></span>
		</fieldset>
		<a href="#" id="back">Back to login...</a>
	</form>
</body>
</html>
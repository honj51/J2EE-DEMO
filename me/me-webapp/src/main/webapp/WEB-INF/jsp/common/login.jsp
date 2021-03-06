<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<base href="<%=basePath%>" />
	<title>GrossoFans</title>

	<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/invalid.css" type="text/css" media="screen" />
	<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="js/me.js"></script>
	<script type="text/javascript">
	
	</script>
</head>

<body id="login">
	<div id="login-wrapper" class="png_bg">
		<div id="login-top">
			<h1>GrossoFans</h1>
			<a href="http://grosso.iteye.com/" target="_blank">
				<img id="logo" src="images/logo.png" />
			</a>
		</div>
		<div id="login-content">
			<form action="common/login-process" method="post">
				<c:if test="${hasErrors}">
				<div class="notification error png_bg">
					<div>
						<c:forEach items="${loginErrors}" var="msg">
							<c:out value="${msg}" /> <br/>
						</c:forEach>
					</div>
				</div>
				</c:if>
				<p>
					<label>Username</label> <input class="text-input" type="text" name="username" />
				</p>
				<div class="clear"></div>
				<p>
					<label>Password</label> <input class="text-input" type="password" name="password" />
				</p>
				<div class="clear"></div>
				<p id="remember-password">
					<input type="checkbox" name="_remember_me" checked="checked" /> Remember me
				</p>
				<div class="clear"></div>
				<p>
					<input class="button" type="submit" value="Sign In" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>


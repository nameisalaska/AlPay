<%@ page language="java" contentType="text/html; charset= UTF-8 "
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="web.resources.i18n.done"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8  ">
<title></title>
<link rel="stylesheet" type="text/css" href="style/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="style/css/animate-custom.css" />
</head>
<body>
	<div class="container">
		<div id="container_demo">
			<div id="wrapper">
				<div id="login" class="animate form">
					<form action="done" autocomplete="on" method = "POST">
						<p>
							<h1>${message}</h1>
						</p>
						<p class="login button">
							<input type="submit" value="<fmt:message key="done.button.submit"/>" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
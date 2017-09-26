<%@ page language="java" contentType="text/html; charset= UTF-8 "
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="web.resources.i18n.BlockCardForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8  ">
<title><fmt:message key="adminblockuser.unblocking"/></title>
<link rel="stylesheet" type="text/css" href="style/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="style/css/animate-custom.css" />
</head>
<body>
	<div class="container">
		<div id="container_demo">
			<div id="wrapper">
				<div id="login" class="animate form">
					<form action="user_cardblocking" autocomplete="on" method = "POST">
						<h1><fmt:message key="adminblockuser.action"/></h1>
						<p>
							<label for="username" class="uname" data-icon="u"> <fmt:message
									key="adminblockuser.username" />
							</label> <input id="username" name="username" required="required"
								type="text" required pattern="^[a-zA-Z](.[a-zA-Z0-9_-]*)$"
								placeholder="myusername" />
						</p>
						<p class="login button">
							<input type="submit" value="<fmt:message key="adminblockuser.submit"/>" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
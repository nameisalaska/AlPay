<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="web.resources.i18n.CardAddingForm" />
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8 ">
<title><fmt:message key="cardForm.title" /></title>
<link rel="stylesheet" type="text/css" href="style/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="style/css/animate-custom.css" />
</head>
</head>
<body>
	<div class="container">
		<div id="container_demo">
			<div id="wrapper">
				<div id="login" class="animate form">
					<form action="user_cardAdding" autocomplete="on" method="POST">
						<h1><fmt:message key="cardForm.card.action" /></h1>
						<p>
							<label for="account_number" class="uname"><fmt:message key="cardForm.cardNumber" /></label> <input
								id="account_number" name="account_number"
								type="text" required pattern="[0-9]{16}" maxlength="16" placeholder="XXXXXXXXXXXXXXXX" required/>
						</p>
						<p class="login button">
							<input type="submit" value="<fmt:message key="cardForm.submit" />" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
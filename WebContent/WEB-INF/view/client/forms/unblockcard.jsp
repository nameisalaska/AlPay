<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="web.resources.i18n.unblockCardForm" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8 ">
<title><fmt:message key="unblockForm.title" /></title>
<link rel="stylesheet" type="text/css" href="style/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="style/css/animate-custom.css" />
</head>
<body>
	<div class="container">
		<div id="container_demo">
			<div id="wrapper">
				<div id="login" class="animate form">
					<form action="user_cardunblocking" autocomplete="on" method="">
						<h1>
							<fmt:message key="unblockForm.action" />
						</h1>
						<p>
							<label for="cardnumberunblock" class="uname"><fmt:message
									key="unblockForm.cardNumber" /></label> <input id="cardnumberunblock"
								required pattern="[0-9]{16}" maxlength="16"
								name="cardnumberunblock" required="required" type="text"
								placeholder="XXXXXXXXXXXXXXXX" />
						</p>
						<p class="signin button">
							<input type="submit"
								value="<fmt:message key="unblockForm.send" />" />
						</p>
						<p>
							<c:out value="${errorText}" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
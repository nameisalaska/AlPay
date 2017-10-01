<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="web.resources.i18n.CardAddingForm" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8 ">
<title><fmt:message key="cardForm.account.title" /></title>
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
					<form action="user_accountAdding" autocomplete="on" method="POST">
						<h1><fmt:message key="cardForm.action" /></h1>
						<p>
							<label for="cardnumber" class="uname"><fmt:message key="cardForm.cardNumber" /></label> <input
								id="cardnumber" name="cardnumber"
								type="text" required pattern="[0-9]{16}" maxlength="16" placeholder="XXXXXXXXXXXXXXXX" required/>
						</p>
							<label for="name" class="uname"> <fmt:message
									key="cardForm.name" />
							</label> <input id="name" name="name" required="required"
								type="text" maxlength="30"		 />
						<p>
							<label for="pin" class="youpasswd" data-icon="p">
								PIN </label> <input id="pin" name="pin"
								type="password" required pattern="[0-9]{4}" maxlength="4" placeholder="XXXX" required />
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
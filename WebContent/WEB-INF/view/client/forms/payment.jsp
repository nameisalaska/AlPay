<%@ page language="java" contentType="text/html; charset= UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="web.resources.i18n.PaymentForm" />
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8 ">
<title><fmt:message key="paymentForm.title" /></title>
<link rel="stylesheet" type="text/css" href="style/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="style/css/animate-custom.css" />
</head>
<body>
	<div class="container">
		<div id="container_demo">
			<div id="wrapper">
				<div id="login" class="animate form">
					<form action="user_payment" autocomplete="on" method="POST">
						<h1>
							<fmt:message key="paymentForm.title" />
						</h1>
						<p>
							<label for="cardnumberfrom" class="uname"><fmt:message
									key="paymentForm.from" /></label> <input id="cardnumberfrom" required
								pattern="[0-9]{16}" maxlength="16" name="cardnumberfrom"
								required="required" type="text" placeholder="XXXXXXXXXXXXXXXX" />
						</p>
						<p>
							<label for="cardnumberto" class="uname"><fmt:message
									key="paymentForm.to" /></label> <input id="cardnumberto" required
								pattern="[0-9]{16}" maxlength="16" name="cardnumberto"
								required="required" type="text" placeholder="XXXXXXXXXXXXXXXX" />
						</p>
						<p>
							<label for="sum" class="uname"><fmt:message
									key="paymentForm.amount" /></label> <input id="sum" name="sum"
								required="required" type="number" placeholder="0" />
						</p>
						<p>
							<c:out value="${errorText}" />
						</p>
						<p class="login button">
							<input type="submit" value="<fmt:message key="paymentForm.submit" />" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
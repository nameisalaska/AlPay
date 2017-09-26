<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="web.resources.i18n.login" />
<!DOCTYPE html>
<html lang="${language}" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login and registration</title>
<link href="style/css/animate-custom.css" rel="stylesheet"
	type="text/css" />
<link href="style/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div id="container_demo">
			<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
			<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
				id="tologin"></a>
			<div id="wrapper">
				<div id="login" class="animate form">
					<form action="lang">
						<select name=lang onchange="submit()">
							<option selected disabled><fmt:message
									key="language" /></option>
							<option value="en">English</option>
							<option value="ru">Russian</option>
						</select>
					</form>
					<form action="autorization" autocomplete="on" method="POST">
						<h1>
							<fmt:message key="header" />
						</h1>
						<p>
							<label for="username" class="uname" data-icon="u"> <fmt:message
									key="login.label.username" />
							</label> <input id="username" name="username" required="required"
								type="text" required pattern="^[a-zA-Z](.[a-zA-Z0-9_-]*)$"
								placeholder="myusername" />
						</p>
						<p>
							<label for="password" class="youpasswd" data-icon="p"> <fmt:message
									key="login.label.password" />
							</label> <input id="password" name="password" required="required"
								type="password" placeholder="eg. X8df!90EO" />
						</p>
						<p class="login button">
							<input type="submit"
								value="<fmt:message key="login.button.submit" />" />
						</p>
						<p>
							<c:out value="${errorText}" />
						</p>
						<p class="change_link">
							<fmt:message key="form1.message" />
							<a href="#toregister" class="to_register"><fmt:message
									key="form1.link" /></a>
						</p>
					</form>
				</div>

				<div id="register" class="animate form">
					<form action="registration" autocomplete="on" method="POST">
						<h1>
							<fmt:message key="header2" />
						</h1>
						<p>
							<label for="usernamesignup" class="uname" data-icon="u"><fmt:message
									key="login.label.username" /></label> <input id="usernamesignup"
								required pattern="^[a-zA-Z](.[a-zA-Z0-9_-]*)$"
								name="usernamesignup" required="required" type="text"
								placeholder="mysuperusername690" />
						</p>
						<p>
							<label for="emailsignup" class="youmail" data-icon="e"><fmt:message
									key="login.label.email" /></label> <input id="emailsignup"
								name="emailsignup" required="required" type="email"
								placeholder="mysupermail@mail.com" />
						</p>
						<p>
							<label for="passwordsignup" class="youpasswd" data-icon="p"><fmt:message
									key="login.label.password" /></label> <input id="passwordsignup"
								name="passwordsignup" required="required" type="password"
								placeholder="eg. X8df!90EO" />
						</p>
						<p>
							<label for="passwordsignup_confirm" class="youpasswd"
								data-icon="p"><fmt:message
									key="login.label.password.confirm" /> </label> <input
								id="passwordsignup_confirm" name="passwordsignup_confirm"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p>
						<p class="signin button">
							<input type="submit" value="<fmt:message key="header2" />" />
						</p>
						<p class="change_link">
							<fmt:message key="form2.message" />
							<a href="#tologin" class="to_register"> <fmt:message
									key="form2.link" />
							</a>
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
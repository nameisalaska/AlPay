<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8 ">
<title>Replenish</title>
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
					<form action="user_replensih" autocomplete="on" method="POST">
						<h1>Replenish the card</h1>
						<p>
							<label for="cardnumber" class="uname">Card number</label> <input
								id="cardnumber" name="cardnumber" required="required"
								type="text" required pattern="[0-9]{16}"   maxlength="16"  placeholder="XXXXXXXXXXXXXXXX" />
						</p>
						<p>
							<label for="sum" class="uname">Transfer amount</label> <input
								id="sum" name="sum" required= "required" type="number" placeholder="0" />
						</p>
						<p class="login button">
							<input type="submit" value="Submit" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8 ">
<title>Unblocking</title>
  <link rel="stylesheet" type="text/css" href="style/css/style.css" />
		<link rel="stylesheet" type="text/css" href="style/css/animate-custom.css" />
</head>
<body>
 <div class="container">
                <div id="container_demo" >
                    <div id="wrapper">
                        <div id="login" class="animate form">
                             <form  action="user_cardunblocking" autocomplete="on" method = "">
                                <h1> Unblock the card </h1>
                                <p>
                                    <label for="cardnumberunblock" class="uname">Card number</label>
                                    <input id="cardnumberunblock" required pattern="[0-9]{16}"  maxlength="16"  name="cardnumberunblock" required="required" type="text" placeholder="XXXXXXXXXXXXXXXX" />
                                </p>
                                <p class="signin button">
									<input type="submit" value="Send request"/>
								</p>
                            </form>
                        </div>
                    </div>
                </div>
        </div>
</body>
</html>
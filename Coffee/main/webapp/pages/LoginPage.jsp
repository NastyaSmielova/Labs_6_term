<%@taglib prefix="my" uri="/tagLib.tld"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%-- 
    Document   : client
    Created on : May 21, 2017, 3:32:55 PM
    Author     : pc
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
                <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Login Page</title>
                <link href="<c:url value="/css/main.css" />" rel="stylesheet">

	</head>

	<body>
            <h1>
            <my:HelloTag> </my:HelloTag>
            </h1>
            <form  method="post" action ="contr">
                      <input type="hidden" name="command" value="login"/>

                        Please enter your name
			<input type="text" name="name"/><br><br>
			Please enter your password
			<input type="password" name="password"/><br><br>
                        <input type="checkbox" name="chechBox" value="isAdmin"> is Admin <br><br>
			<input type="submit" value="Enter">	
                        <br><br>		
		</form>
	</body>
</html>

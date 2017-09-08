<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page import="java.util.ArrayList"%>
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
            <title>User Page</title>
            <script src="<c:url value="/js/main.js" />"></script>
            <link href="<c:url value="/css/main.css" />" rel="stylesheet">
            
	</head>
	<body  onload="myFunction()">

      <form method = "Post">
          
        <input type="hidden" name="command" value="makeOrder"/>

          <input type="hidden" id = "textToSendDrinks" name = "textToSendDrinks"> 
                    <input type="hidden" id = "textToSendIngridients" name = "textToSendIngridients"> 
                    <input type="hidden" id = "price" name = "price"> 

      <input type="submit"  value="pay for it">	<br>

      </form >
      
      <form  method="post" >
          <button type="submit" id="submit" style.visiablity="hidden">submit</button>
                    <input type="hidden" name="command" value="userInit"/>

                    <div class="block1">
                        <c:forEach items="${drinks}" var="drink" >
                            <li><button type="button"  value="drink${drink.ID}"  onclick="OnClick('drink',${drink.ID},'${drink.name}',${drink.price})">${drink.name}  ${drink.price}</button> <br><br></li>
                        </c:forEach>    
                            </div>
                             <div class="block2">
                                 <ul id="list">
                                 </ul> 
                            </div>
                            <div class="block3">
                        <c:forEach items="${ingridients}" var="ingridient">
                            <li><button type="button" onclick="OnClick('ingridient',${ingridient.ID},'${ingridient.name}',${ingridient.price})"> ${ingridient.name}  ${ingridient.price}</button> <br><br></li>
                        </c:forEach>  
	
		</form>
                <script>
                    function myFunction() {
                        var hangoutButton = document.getElementById("submit");
                        document.getElementById("submit").style.display = 'none';
                        document.getElementById("price").value = 0;
                        document.getElementById("textToSendIngridients").value = null;
                        document.getElementById("textToSendIngridients").value = null;

                         <c:if test="${drinks == null}">
                              hangoutButton.click();
                        </c:if>
                }
                </script>
	</body>
</html>

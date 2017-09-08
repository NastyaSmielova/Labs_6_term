<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%-- 
    Document   : userLogged
    Created on : May 21, 2017, 3:38:27 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
            <title>User Page</title>
            <script src="<c:url value="/js/main.js" />"></script>
            <link href="<c:url value="/css/main.css" />" rel="stylesheet">

	</head>
	<body onload="myFunction()">
            
      <form method = "Post">
           <input type="hidden" name="command" value="addProducts"/>
          <input type="hidden" id = "textToSendDrinks" name = "textToSendDrinks"> 
                    <input type="hidden" id = "textToSendIngridients" name = "textToSendIngridients"> 
                    <input type="hidden" id = "price" name = "price"> 


      <input type="submit"  value="increase value">	<br>

      </form >
            <form  method="post" >
                          <button type="submit" id = "submit">submit</button>

                           <input type="hidden" name="command" value="adminInit"/>

			<c:forEach items="${result}" var="item">
                            <li><button type="button" >${item}</button> <br></li>
                        </c:forEach>
                            <div class="block1">
                        <c:forEach items="${drinks}" var="drink" >
                            <li><button type="button"  value="drink${drink.ID}"  onclick="OnClick('drink',${drink.ID},'${drink.name}',${drink.price})">${drink.name}  ${drink.price}</button> <br><br></li>
                        </c:forEach>    
                            </div>
                             <div class="block2">
                                 <span id="demo"></span>
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
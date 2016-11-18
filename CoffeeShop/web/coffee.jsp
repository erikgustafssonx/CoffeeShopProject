<%-- 
    Document   : coffee
    Created on : Apr 21, 2015, 3:13:13 PM
    Author     : Asus-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Welcome to Coffe Tougce</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body id="body">
        <div id="container" align="middle"><img class ="logo" src="Pic/coffee.jpg" alt="my coffe shop"  >
            <div id="bgc">
                <div class="menu">
                    <c:forEach items="${productList}" var="product">
                                <div class="shp"><h2>${product.name}</h2><br>
                             ${product.description}
                            ${product.price} Kr
                            
                        <c:if test="${admin == true}">
                            <a href="Edit?product_id=${product.id}"><button>Edit</button></a>
                        </c:if>
                        <a href="Buy?product_id=${product.id}"><button>Buy</button></a>
                        
                                    </div>
                                <br>
                    </c:forEach>
                </div>
            </div>
            
    
        </div>
        
   
    </body>
</html>

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
                <div class="content">
                    <div class="menu">
                        <a href="ProductList">Products</a>
                        <c:if test="${!empty currentCustomer}">
                            <a href="MyOrders">My Orders</a>
                        </c:if>
                        <a href="GuestBook">Guest book</a>
                        <c:if test="${empty currentCustomer}">
                            <a href="CustomerLogin">Customer login</a>
                        </c:if>
                        <c:if test="${!empty currentCustomer}">
                            Logged in as ${currentCustomer.email}<a href="CustomerLogout">Log out</a>
                        </c:if>                        
                    </div>
                    <br/>
                    <c:if test="${!empty ErrorMessage}">
                           ${ErrorMessage}<br/> 
                    </c:if>
                    <c:if test="${!empty Message}">
                        ${Message}<br/>
                    </c:if>
                    <c:choose>
                        <c:when test="${subpage == 'Admin'}">
                            <%@include file="Admin.jsp"%>
                        </c:when>
                        <c:when test="${subpage == 'CustomerLogout'}">
                            <%@include file="CustomerLogout.jsp"%>
                        </c:when>
                        <c:when test="${subpage == 'CustomerLogin'}">
                            <%@include file="CustomerLogin.jsp"%>
                        </c:when>
                        <c:when test="${subpage == 'WelcomeCustomer'}">
                            <%@include file="WelcomeCustomer.jsp"%>
                        </c:when>
                        <c:when test="${subpage == 'RegisterCustomer'}">
                            <%@include file="RegisterCustomer.jsp"%>
                        </c:when>
                        <c:when test="${subpage == 'CustomerLogin'}">
                            <%@include file="CustomerLogin.jsp"%>
                        </c:when>
                        <c:when test="${subpage == 'ProductList'}">
                            <%@include file="ProductList.jsp"%>
                        </c:when>
                        <c:when test="${subpage == 'GuestBook'}">
                            <%@include file="GuestBook.jsp"%>
                        </c:when>
                        <c:when test="${subpage == 'MyOrders'}">
                            <%@include file="MyOrders.jsp"%>
                        </c:when>
                        <c:when test="${subpage == 'MessageOnly'}">
                            <%-- We dont want to include any subpage--%>
                        </c:when>
                        <c:otherwise>Page does not exist</c:otherwise>
                    </c:choose>
                </div>
            </div>
            
    
        </div>
        
   
    </body>
</html>

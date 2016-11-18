<%-- 
    Document   : coffee
    Created on : Apr 21, 2015, 3:13:13 PM
    Author     : Asus-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
         <link rel="stylesheet" type="text/css" href="style.css">
        <title>Welcome to Coffe Tougce</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body id="body">
        ${user.picture}
        <div id="container" align="middle"><img class ="logo" src="Pic/coffee.jpg" alt="my coffe shop"  >
            <div id="bgc">
                <div class="menu">
                    <div class="shp"><h2>${product.name}</h2><br>
                        <form method="get">
                            Name: <input type="text" name="name" value="${product.name}"><br/>
                            Desription:<input type="text" name="descripton" value = "${product.description}"><br>
                            Price: <input type="text" name="price" value="${product.price}">
                            <input type="hidden" name="product_id" value="${product.id}">
                            <input name="submit" type="submit" value="Save">
                        </form>
                        ${message}<br/>
                        <a href="ProductList">Back</a>
                     </div>
                </div>
                
            </div>
            
    
        </div>
        
   
    </body>
</html>

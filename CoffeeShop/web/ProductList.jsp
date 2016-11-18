Wanna get the latest updates of our prices into your own application?<br/>
Use our API: http://localhost:8080/CoffeeShop/API/Products/<br/>
<p>ProductList</P>
<c:forEach items="${productList}" var="product">
            <div class="shp"><h2>${product.name}</h2><br>
         ${product.description}
         ${product.price} Kr<br>

    <c:if test="${admin == true}">
        <a href="Edit?product_id=${product.id}"><button>Edit</button></a>
    </c:if>
    <c:if test="${!empty currentCustomer}">
        <a href="MakeOrder?product_id=${product.id}"><button>Make order</button></a>
    </c:if>
    <c:if test="${empty currentCustomer}">
        You need to login as customer to place orders
    </c:if>

                </div>
            <br>
</c:forEach>
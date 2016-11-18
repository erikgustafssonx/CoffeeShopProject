<h1>Admin page - all orders<h1>
<c:forEach items="${orderList}" var="order">
    <div class="shp">
        
    <h2>Order number:${order.id}</h2>
    Order placed: ${order.timestamp}<br/>
    Status: ${order.statusName}<br/>
    Product: ${order.product.name}<br/>
    Price: ${order.product.price} kr<br/>
    <c:if test="${order.status==0}">
    <a href="?deliver=${order.id}"><button>Deliver</button></a>
    </c:if>
    </div>
    <br/>
</c:forEach>
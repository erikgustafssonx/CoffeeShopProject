<h1>My Orders<h1>
<c:forEach items="${orderList}" var="order">
    <div class="shp">
        
    <h2>Order number:${order.id}</h2>
    Order placed: ${order.timestamp}<br/>
    Status: ${order.statusName}<br/>
    Product: ${order.product.name}<br/>
    Price: ${order.product.price} kr<br/>
    </div>
    <br/>
</c:forEach>
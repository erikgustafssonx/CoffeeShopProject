<c:if test="${empty currentCustomer}">
     You must be logged in to write in guest book<br/><br/>
 </c:if>
 <c:if test="${!empty currentCustomer}">
     <form>
    <textarea name="message"></textarea>
    <input type="submit" name="submit_message" value="Send">
    </form>
 </c:if>  
<c:forEach items="${guestBookMessages}" var="guestBookMessage">
            <div class="shp"><h2>From ${guestBookMessage.customer.email}</h2><br>
                    ${guestBookMessage.message}
                </div>
            <br>
</c:forEach>
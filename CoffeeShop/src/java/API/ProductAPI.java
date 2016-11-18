//http://localhost:8080/CoffeeShop/API/Products/get/Ulrik
package API;
import Model.*;
import java.util.ArrayList;
import javax.ws.rs.core.Application;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

// The Java class will be hosted at the URI path "/helloworld"
@Path("Products")
public class ProductAPI {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getProductsInJSON() {
            ArrayList<Product> Products = new ProductManager().getProducts();
            
            return Products;

    }
}
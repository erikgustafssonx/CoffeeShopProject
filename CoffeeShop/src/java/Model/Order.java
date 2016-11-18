/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.naming.NamingException;

/**
 *
 * @author ekir
 */
public class Order {
    private Timestamp timestamp;
    private int customerId;
    private int productId;
    private int id;
    int status; // Status = 0 is not deliverd Status=1 is delivered
    
    public String getStatusName() {
        if(status==0) {
            return "Not delivered";
        }
        if(status==1) {
            return "Delivered";
        }
        return "Undefined";
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public void loadResultSet(ResultSet rset) throws SQLException {
        status = rset.getInt("status");
        timestamp = rset.getTimestamp("timestamp");
        id=rset.getInt("id");
        customerId=rset.getInt("customer");
        productId=rset.getInt("product");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    
    public Product getProduct() throws SQLException, NamingException {
        Product tmp_product = new ProductManager().getProductById(productId);
        return tmp_product;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int CustomerId) {
        this.customerId = CustomerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int ProductId) {
        this.productId = productId;
    }
    
}

package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ekir
 */
public class GuestBookMessage {
    private Connection getConnection() throws NamingException, SQLException {
        InitialContext context = new InitialContext();
        DataSource DS = (DataSource)context.lookup("jdbc/CoffeeHouse");
        return DS.getConnection();
    }
    
    public void load(int id) throws NamingException, SQLException {
        Connection conn=getConnection();
        PreparedStatement pstmt = conn.prepareStatement("Select * from guestbookmessage where id=?");
        pstmt.setInt(1,id);
        ResultSet rset=pstmt.executeQuery();
        if(rset.next()) {
            loadResultSet(rset);
        }
        conn.close();
    }
    
    public void loadResultSet(ResultSet rset) throws SQLException {
        id=rset.getInt("id");
            customerId=rset.getInt("customerid");
        message=rset.getString("message");
    }
    
    public Customer getCustomer() throws SQLException, NamingException {
        Customer tmp_customer = new CustomerManager().getCustomerById(customerId);
        return tmp_customer;
    }
    
    public void setCustomer(Customer t) throws SQLException {
        // Do nothing
    }
    
    private int id;
    private String message;
    private int customerId;
    private Customer customer;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}

package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Stateless;
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
@Stateless
public class ProductManager {
    private Connection getConnection() {
        try {
        InitialContext context = new InitialContext();
        DataSource DS = (DataSource)context.lookup("jdbc/CoffeeHouse");
        return DS.getConnection();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Product getProductById(int id) throws SQLException, NamingException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM products WHERE id=?");
        pstmt.setInt(1,id);
        ResultSet rset=pstmt.executeQuery();
        conn.close();
        if(rset.next()) {
            Product tmp_product = new Product();
            tmp_product.loadResultSet(rset);
            return tmp_product;
        } else {
            return null;
        }
    }
        
    public ArrayList<Product> getProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("Select * from products");
            ResultSet rset=pstmt.executeQuery();
            while(rset.next()) {
                Product tmp_product=new Product();
                tmp_product.setId(rset.getInt("id"));
                tmp_product.setName(rset.getString("name"));
                tmp_product.setDescription(rset.getString("description"));
                tmp_product.setPrice(rset.getInt("price"));
                productList.add(tmp_product);
            }
            conn.close();
        } catch (SQLException e) {
            
        }
        return productList;
    }
}

package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.InitialContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ekir
 */
public class Product implements java.io.Serializable {
    private int id;
    private String description;
    private int price;
    
    public void setId(int id) {
        this.id=id;
    }
    
    public int getId() {
        return id;
    }
    private Connection getConnection() {
        try {
        InitialContext context = new InitialContext();
        DataSource DS = (DataSource)context.lookup("jdbc/CoffeeHouse");
        return DS.getConnection();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Product() {
        id=1;
        description="";
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public void loadResultSet(ResultSet rset) throws SQLException {
        id=rset.getInt("id");
        name=rset.getString("name");
        description=rset.getString("description");
        price=rset.getInt("price");
    }
    
    public void save() throws SQLException {
           Connection conn=getConnection();
           PreparedStatement pstmt = conn.prepareStatement("UPDATE products SET name=?,description=?,price=? WHERE id=?");
           pstmt.setString(1, name);
           pstmt.setString(2, description);
           pstmt.setInt(3, price);
           pstmt.setInt(4,id);
           pstmt.executeUpdate();
           conn.close();
    }
    public void load(int id) {
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt = conn.prepareStatement("Select * from products where id=?");
            pstmt.setInt(1,id);
            ResultSet rset=pstmt.executeQuery();
            if(rset.next()) {
                this.id=id;
                name=rset.getString("name");
                description=rset.getString("description");
                price=rset.getInt("price");
            }
            conn.close();
        } catch (SQLException ex) {
            
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String productDescription) {
        this.description = productDescription;
    }
}

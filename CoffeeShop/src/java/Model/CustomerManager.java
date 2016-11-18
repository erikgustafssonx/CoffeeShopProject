package Model;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class CustomerManager {
    private DataSource DS;
    
    private Connection getConnection() throws SQLException, NamingException {
        if(DS==null) {
            InitialContext context = new InitialContext();
            DS = (DataSource)context.lookup("jdbc/CoffeeHouse");
        }
        return DS.getConnection();
    }
    
    public String hashPassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        // From example: http://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash
        byte[] bytesOfMessage = password.getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5sum = md.digest(bytesOfMessage);
        // http://www.javalobby.org/java/forums/t84420.html
        BigInteger bigInt = new BigInteger(1, md5sum);
        String output = bigInt.toString(16);
        return output;
    }
    
    public Customer getCustomerById(int id) throws SQLException, NamingException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customers WHERE id=?");
        pstmt.setInt(1,id);
        ResultSet rset=pstmt.executeQuery();
        conn.close();
        if(rset.next()) {
            Customer tmp_customer = new Customer();
            tmp_customer.loadResultSet(rset);
            return tmp_customer;
        } else {
            return null;
        }
    }
    
    
    public Customer getCustomerByEmail(String email) throws SQLException, NamingException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customers WHERE email=?");
        pstmt.setString(1,email);
        ResultSet rset=pstmt.executeQuery();
        conn.close();
        if(rset.next()) {
            Customer tmp_customer = new Customer();
            tmp_customer.loadResultSet(rset);
            return tmp_customer;
        } else {
            return null;
        }
    }
    
    public boolean createCustomer(String email,String password) throws NamingException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException, CoffeeShopException {
        if(getCustomerByEmail(email)!=null) {
            throw new CoffeeShopException("Email "+email+" is already registered");
        }
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO customers(email,pwhash) VALUES (?,?)");
        pstmt.setString(1,email);
        pstmt.setString(2,hashPassword(password));
        pstmt.execute();
        conn.close();
        return true;
    }
    
    public Customer testLogin(String email, String password) throws SQLException, CoffeeShopException, UnsupportedEncodingException, NoSuchAlgorithmException, NamingException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customers WHERE email=?");
        pstmt.setString(1,email);
        ResultSet rset=pstmt.executeQuery();
        conn.close();
        if(rset.next()) {
            String pwhash=rset.getString("pwhash");
            if(pwhash.compareTo(hashPassword(password))==0) {
                Customer customer=new Customer();
                customer.loadResultSet(rset);
                return customer;
            } else {
                throw new CoffeeShopException("Invalid password "+hashPassword(password));
            }
        }
        throw new CoffeeShopException("User with email "+email+" does not exist");
    }
}

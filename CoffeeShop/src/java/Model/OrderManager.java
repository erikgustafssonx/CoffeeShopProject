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

/**
 *
 * @author ekir
 */
@Stateless
public class OrderManager {
    private DataSource DS;
    
    private Connection getConnection() throws SQLException, NamingException {
        if(DS==null) {
            InitialContext context = new InitialContext();
            DS = (DataSource)context.lookup("jdbc/CoffeeHouse");
        }
        return DS.getConnection();
    }
    
    public Order getOrder(int id) throws SQLException, NamingException {
        Order tmpOrder = new Order();
        Connection conn=getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * from orders where id=?");
        pstmt.setInt(1,id);
        ResultSet rset=pstmt.executeQuery();
        if(rset.next()) {
            tmpOrder.loadResultSet(rset);
        }
        conn.close();
        return tmpOrder;
    }
    
    public void saveOrder(Order order) throws SQLException, NamingException {
        Connection conn=getConnection();
        PreparedStatement pstmt = conn.prepareStatement("UPDATE orders SET status=? WHERE id=?");
        pstmt.setInt(1, order.getStatus());
        pstmt.setInt(2, order.getId());
        pstmt.executeUpdate();
        conn.close();
    }
    
    public ArrayList<Order> getOrders() throws SQLException, NamingException {
        ArrayList<Order> orderList = new ArrayList<Order>();
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from orders order by id desc");
        ResultSet rset=pstmt.executeQuery();
        while(rset.next()) {
            Order tmpOrder=new Order();
            tmpOrder.loadResultSet(rset);
            orderList.add(tmpOrder);
        }
        conn.close();
        return orderList;
    }
    
    public ArrayList<Order> ordersByCustomer(int customerId) throws SQLException, NamingException {
        ArrayList<Order> orderList = new ArrayList<Order>();
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from orders where customer=? order by id desc");
        pstmt.setInt(1, customerId);
        ResultSet rset=pstmt.executeQuery();
        while(rset.next()) {
            Order tmpOrder=new Order();
            tmpOrder.loadResultSet(rset);
            orderList.add(tmpOrder);
        }
        conn.close();
        return orderList;
    }
    
    public void createOrder(int customerId,int productId) throws NamingException, SQLException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO orders (customer,product) VALUES(?,?)");
        pstmt.setInt(1,customerId);
        pstmt.setInt(2,productId);
        pstmt.execute();
        conn.close();
    }    
}

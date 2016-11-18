package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
public class GuestBookMessageManager {
    private DataSource DS;
    
    public void assignDataSource(DataSource DS) {
        this.DS=DS;
    }
    
    public void createMessage(String message, int customerId) throws NamingException, SQLException {
        GuestBookMessage returnGuestBookMessage;
        Connection conn = DS.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO guestbookmessage(message,customerid) VALUES (?,?)");
        pstmt.setString(1,message);
        pstmt.setInt(2,customerId);
        pstmt.execute();
        conn.close();
    }
    
    public ArrayList<GuestBookMessage> getGuestBookMessages() throws NamingException, SQLException {
        ArrayList<GuestBookMessage> guestBookMessageList = new ArrayList<>();
        Connection conn = DS.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from guestbookmessage order by id desc");
        ResultSet rset=pstmt.executeQuery();
        while(rset.next()) {
            GuestBookMessage tmp_GuestBookMessage=new GuestBookMessage();
            tmp_GuestBookMessage.loadResultSet(rset);
            guestBookMessageList.add(tmp_GuestBookMessage);
        }
        conn.close();
        return guestBookMessageList;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author ekir
 */
@WebServlet(urlPatterns = {"/CustomerLogin"})
public class CustomerLogin extends HttpServlet {
    @EJB
    private CustomerManager customerManager;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     try {
            HttpSession sess = request.getSession();
            if(sess.getAttribute("currentCustomer")!=null) {
                request.setAttribute("Message","You are alreday logged in");
                request.setAttribute("subpage","CustomerLogin");
                request.getRequestDispatcher("MainTemplate.jsp").forward(request, response);
                return;
            }
            //request.setAttribute("Message", "pwhash"+customerManager.pwhash("hej"));
            if(request.getParameter("submit_login")!=null) {
                String email=request.getParameter("email");
                String password=request.getParameter("password");
                Customer currentCustomer = customerManager.testLogin(email,password);
                if(currentCustomer!=null) {
                    sess.setAttribute("currentCustomer",currentCustomer);
                }
                request.setAttribute("Message", "You are now logged in");
                request.setAttribute("subpage","MessageOnly");
                request.getRequestDispatcher("MainTemplate.jsp").forward(request, response);
                return;
             }
        } catch (Exception e) {
                request.setAttribute("ErrorMessage","Error: "+e.getMessage());
        }
        request.setAttribute("subpage","CustomerLogin");
        request.getRequestDispatcher("MainTemplate.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package webd4201.carlosi;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * This servlet simply removes the Student object from the session.
 * 
 * @author Ian Carlos
 * @since 1.0 (2019/2/18)
 * @version 1.0
 */
public class LogoutServlet extends HttpServlet{
   
    /**
     * 
     * This is where a logged in Student will be removed from the session.
     * 
     * @param request HTTP request
     * @param response HTTP response
     * @throws ServletException if there was general servlet error encountered
     * @throws IOException if there was a general InputOuput error encountered
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true); //retrieve the session (or start)       
        
        session.removeAttribute("student"); //remove the object stored at login
        
        session.setAttribute("message","You have successfully logged out"); //give an informational message
        
        response.sendRedirect("./login.jsp");  //redirect to login.jsp
    }
    
    /**
     * 
     * This is where a logged in Student will be removed from the session.     
     * 
     * @param request HTTP request
     * @param response HTTP response
     * @throws ServletException if there was general servlet error encountered
     * @throws IOException if there was a general InputOuput error encountered
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        
        //retrieve the session (or start)   
        session.removeAttribute("student"); 
        
        //remove the object stored at login
        //give an informational message
        session.setAttribute("message", "You have successfully logged out");      
        
        // redirect to login.jsp
        response.sendRedirect("./login.jsp");  
    } 
}

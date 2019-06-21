package webd4201.carlosi;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * 
 * This servlet will attempt to validate the student ID and password entered
 * by the user from login.jsp. If the student is found, the returned Student 
 * object should be loaded onto the session, and the servlet should then 
 * redirect the user to the dashboard.jsp.
 * 
 * @author Ian Carlos
 * @since 1.0 (2019/2/18)
 * @version 1.0
 */
public class LoginServlet extends HttpServlet {

    /**
     * 
     * This is where the information entered by the user from login.jsp
     * will attempt to authenticate if the Student exists in the database.
     * 
     * @param request HTTP request
     * @param response HTTP response
     * @throws ServletException if there was general servlet error encountered
     * @throws IOException if there was an InputOutput error encountered
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {
	   	  
	   	//CREATE A TEXT FILE 
	   	/*String logFile = "./test_log.log";
	    File f = new File(logFile);
	    PrintStream printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream(f)), true);
	    System.setErr(printStream);
	    System.setOut(printStream);
	    System.out.println("Log started: " + new java.util.Date());
	    */
        try
        { 
            // connect to database
            Connection c = DatabaseConnect.initialize();
            Student.initialize(c);
            HttpSession session = request.getSession(true);
            StringBuffer errorBuffer = new StringBuffer();
            
            String login = new String();
            long possibleId = 0;
            
            String password = new String();
            
            try 
            {   // retrieve data from DB
                login = request.getParameter("Login"); //this is the name of the text input box on the form
                password = request.getParameter("Password");
                possibleId = Long.parseLong(login);
                
                String hashedPassword = StudentDA.hashThePassword(password);
   
                Student aStudent = Student.authenticate(possibleId, hashedPassword); //attempt to find the Customer, this could cause a NotFoundException
                // if the Customer was found and retrieved from the db
				//put the found Customer onto the session
                session.setAttribute("student", aStudent);
				//empty out any errors if there were some
                session.setAttribute("errors", "");
                
                // redirect the user to a JSP
                response.sendRedirect("./dashboard.jsp");                
                
                try {
                    
                    boolean isGood = true;
                    
                    // Disable auto-commit mode
                    c.setAutoCommit(false);
                    
                    // Try to retrive all marks of the student ID
                    if (isGood) {
                        Mark.retrieveAll(aStudent.getId());

                        c.commit();
                    } else {
                        isGood = false;
                        
                        c.rollback();
                    }
                                        
                } catch (SQLException sqle) {

                    errorBuffer.append("Something went wrong with the database"
                                + " transaction.");
                    session.setAttribute("errors", errorBuffer.toString());
                    response.sendRedirect("./login.jsp");
                }
                
            } catch( NumberFormatException nfe)
            {
                //new code == way better, if I do say so myself
                //sending errors to the page thru the session
                errorBuffer.append("<strong>Student ID must only contain numeric characters, you entered: " + login +".<br/>");
                errorBuffer.append("Please try again.</strong>");
                session.setAttribute("login", "");
                
                session.setAttribute("errors", errorBuffer.toString());
                response.sendRedirect("./login.jsp");
            
            //for the first deliverable you will have to check if there was a problem
            //with just the password, or login id and password
            //this will require a special method e.g. public static boolean isExistingLogin(String arg);
            }catch( NotFoundException nfe)
            {
                //new code == way better, if I do say so myself
                //sending errors to the page thru the session
                errorBuffer.append("<strong>Your sign in information is not valid.<br/>");
                errorBuffer.append("Please try again.</strong>");
                try{
                    Student.retrieve(possibleId);
                    session.setAttribute("login", login);
                }catch(NotFoundException nfe2)
                {
                  session.setAttribute("login", "");
                }
                session.setAttribute("errors", errorBuffer.toString());
                response.sendRedirect("./login.jsp");
            
            //for the first deliverable you will have to check if there was a problem
            //with just the password, or login id and password
            //this will require a special method e.g. public static boolean isExistingLogin(String arg);
            }             
    } catch (Exception e) //not connected
        {
            System.out.println(e);
            String line1="<h2>A network error has occurred!</h2>";
            String line2="<p>Please notify your system " +
                                                    "administrator and check log. "+e.toString()+"</p>";
            formatErrorPage(line1, line2,response);
        }
    }
    
    /**
     * 
     * Call the doPost method when data is obtained from the login.jsp 
     * form.  
     * 
     * @param request HTTP request
     * @param response HTTP response
     * @throws ServletException if there was general servlet error encountered
     * @throws IOException if there was an InputOutput error encountered
     */
    public void doGet(HttpServletRequest request,
                            HttpServletResponse response)
                                    throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 
     * Print out messages in a specific format.
     * 
     * @param first takes a string args
     * @param second takes a string args
     * @param response HTTP response
     * @throws IOException if a general InputOuput was encountered
     */
    public void formatErrorPage( String first, String second,
            HttpServletResponse response) throws IOException
    {
        PrintWriter output = response.getWriter();
        response.setContentType( "text/html" );
        output.println(first);
        output.println(second);
        output.close();
    }
    
}

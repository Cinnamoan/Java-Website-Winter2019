package webd4201.carlosi;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Objects;

/**
 *
 * This servlet will attempt to update a verified and logged-in user's existing 
 * password to a new one and store in the webd4201 database.
 *
 * @author Ian Carlos
 * @version 1.0 (2019/3/11)
 * @since 1.0
 */
public class ChangePasswordServlet extends HttpServlet {

    /**
     * 
     * This servlet should check if the old password matches the one stored in 
     * the database and then attempt to replace it with the new password once it 
     * has passed through validation and insert it into the database.
     * 
     * @param request the HTTP request
     * @param response the HTTP response
     * @throws ServletException if there was an error in the servlet
     * @throws IOException thrown if there was an InputOuput related error
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // connect to database
            Connection c = DatabaseConnect.initialize();
            Student.initialize(c);
            HttpSession session = request.getSession(true);
            StringBuffer errorBuffer = new StringBuffer();

            String password = new String();
            String newpassword = new String();
            String confirmpassword = new String();

            try {

                password = request.getParameter("CurrentPassword");

                String hashedPassword = StudentDA.hashThePassword(password);
                // Sout this out
                
                Student aStudent = StudentDA.authenticate_password(hashedPassword);

                // If the Student was found and retrieved from the db
                // Put the found Student onto the session
                session.setAttribute("student", aStudent);
                //empty out any errors if there were some
                session.setAttribute("errors", "");

                newpassword = request.getParameter("NewPassword");
                confirmpassword = request.getParameter("ConfirmPassword");

                // Check if newpassword is within range
                if (newpassword.length() <= User.MINIMUM_PASSWORD_LENGTH
                        && newpassword.length() >= User.MAXIMUM_PASSWORD_LENGTH) {

                    // Display error message
                    errorBuffer.append("<strong>Your new password CANNOT be less than ");
                    errorBuffer.append(User.MINIMUM_PASSWORD_LENGTH);
                    errorBuffer.append(" and CANNOT be more than ");
                    errorBuffer.append(User.MAXIMUM_PASSWORD_LENGTH);
                    errorBuffer.append("<br/>Please try again.</strong>");

                // Check if confirmpassword is within range
                } else if (confirmpassword.length() <= User.MINIMUM_PASSWORD_LENGTH
                        && confirmpassword.length() >= User.MAXIMUM_PASSWORD_LENGTH) {

                    // Display error message
                    errorBuffer.append("<strong>Your new password CANNOT be less than ");
                    errorBuffer.append(User.MINIMUM_PASSWORD_LENGTH);
                    errorBuffer.append(" and CANNOT be more than ");
                    errorBuffer.append(User.MAXIMUM_PASSWORD_LENGTH);
                    errorBuffer.append("<br/>Please try again.</strong>");

                // Both newpassword and confirmpassword are within range
                } else {

                    if (newpassword.equals(confirmpassword)) {
                        
                        // Hash the new password
                        String hashedNewPassword = StudentDA.hashThePassword(newpassword);
                        
                        // Set the newpassword
                        aStudent.setPassword(hashedNewPassword);

                        // Update the Student's password
                        aStudent.update();

                    } else {
                        errorBuffer.append("<strong>Your new password and the "
                                + "confirm password are not the same.");
                        errorBuffer.append("Please try again.</strong>");
                    }
                }

            } catch (NotFoundException nfe) {

                //sending errors to the page thru the session
                errorBuffer.append("<strong>Your current password is invalid "
                        + "or cannot be found in the database.<br/>");
                errorBuffer.append("Please try again.</strong>");

            }

        } catch (Exception e) {

            System.out.println(e);
            String line1 = "<h2>A network error has occurred!</h2>";
            String line2 = "<p>Please notify your system "
                    + "administrator and check log. " + e.toString() + "</p>";
            formatErrorPage(line1, line2, response);

        }

    }
    
    /**
     * 
     * Call the doPost method when data is obtained from the changepassword.jsp 
     * form. 
     * 
     * @param request the HTTP request
     * @param response the HTTP response
     * @throws ServletException if there was an error in the servlet
     * @throws IOException if there was an InputOuput related error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 
     * Print out messages in a specific format.
     *
     * @param first string
     * @param second string
     * @param response HTTP response
     * @throws IOException if there was an InputOutput related error
     */
    public void formatErrorPage(String first, String second,
            HttpServletResponse response) throws IOException {
        PrintWriter output = response.getWriter();
        response.setContentType("text/html");
        output.println(first);
        output.println(second);
        output.close();
    }
}

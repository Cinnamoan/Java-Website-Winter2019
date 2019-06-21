package webd4201.carlosi;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;

/**
 *
 * This servlet will validate the form in register.jsp in attempt to create a
 * new Student object and add it to the database.
 *
 * @author Ian Carlos
 * @since 1.0 (2019/3/17)
 * @version 1.0
 */
public class RegisterServlet extends HttpServlet {

    /**
     * 
     * This doPost method will handle validation for all user input variables and attempt
     * to insert it into a database.
     * 
     * @param request HTTP request
     * @param response HTTP response
     * @throws ServletException if a general servlet error was encountered
     * @throws IOException if a general InputOutput error was encountered
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        StringBuffer errorBuffer = new StringBuffer();

        try {
            Connection c = DatabaseConnect.initialize();
            Student.initialize(c);
            HttpSession session = request.getSession(true);

            String theId = new String();
            String firstName = new String();
            String lastName = new String();
            String programCode = new String();
            String programDescription = new String();
            String year = new String();
            String email = new String();
            String password = new String();
            String confirmPassword = new String();

            long possibleId = 0;
            int selectedYear = 0;
            boolean noErrors = true;

            // Declare 'normal' date objects to be converted into SQL dates.
            Date enrolled = new Date();
            Date lastAccessed = new Date();

            // Convert both dates into SQL dates
            java.sql.Date enrolDate = new java.sql.Date(enrolled.getTime());
            java.sql.Date lastAccess = new java.sql.Date(lastAccessed.getTime());

            // Write one big if/else statement for this whadjamacallit
            try {
                // Retrieve data from DB
                theId = request.getParameter("ID").trim();
                firstName = request.getParameter("FirstName").trim();
                lastName = request.getParameter("LastName").trim();
                programCode = request.getParameter("ProgramCode").trim();
                programDescription = request.getParameter("ProgramDescription").trim();
                year = request.getParameter("Year");    // Year is dropdown
                email = request.getParameter("Email").trim();
                password = request.getParameter("Password");
                confirmPassword = request.getParameter("ConfirmPassword");

                // Try to parse the selected value for ID into long.
                possibleId = Long.parseLong(theId);

                if (theId == null) {
                    theId = "";
                    noErrors = false;
                } else if (theId.length() == 0) {
                    errorBuffer.append("<strong>Student ID field "
                            + "cannot be empty.</strong>");

                    theId = "";
                    noErrors = false;
                }

                if (possibleId >= User.ID_NUMBER_LENGTH) {
                    errorBuffer.append("<strong>Your ID cannot be longer than ");
                    errorBuffer.append(User.ID_NUMBER_LENGTH);
                    errorBuffer.append(" characters. Please try again.</strong>");

                    theId = "";
                    noErrors = false;
                } else if (!User.verifyId(possibleId)) {
                    errorBuffer.append("<strong>Your ID cannot be less than ");
                    errorBuffer.append(User.MINIMUM_ID_NUMBER);
                    errorBuffer.append(" and more than ");
                    errorBuffer.append(User.MAXIMUM_ID_NUMBER);
                    errorBuffer.append(" characters.</strong>");

                    theId = "";
                    noErrors = false;
                }

                if (firstName.length() == 0) {
                    errorBuffer.append("<strong>First Name cannot be empty.</strong>");

                    firstName = "";
                    noErrors = false;
                }

                if (lastName.length() == 0) {
                    errorBuffer.append("<strong>Last Name cannot be empty.</strong>");

                    lastName = "";
                    noErrors = false;
                }

                if (programCode.length() == 0) {
                    errorBuffer.append("<strong>Program Code cannot be empty.</strong>");

                    programCode = "";
                    noErrors = false;
                }

                if (programDescription.length() == 0) {
                    errorBuffer.append("<strong>Program Description cannot be empty.</strong>");

                    programDescription = "";
                    noErrors = false;
                }

                // Try to parse the selected value for year into an integer.
                selectedYear = Integer.parseInt(year);

                if (email.length() == 0) {
                    errorBuffer.append("<strong>Email cannot be empty.</strong>");

                    email = "";
                    noErrors = false;
                } else if (!User.isValidEmailAddress(email)) {
                    errorBuffer.append("<strong>Email is invalid.</strong>");

                    email = "";
                    noErrors = false;
                }

                if (password.length() == 0) {
                    errorBuffer.append("<strong>Password cannot be empty.</strong>");

                    password = "";
                    noErrors = false;
                } else if (confirmPassword.length() == 0) {
                    errorBuffer.append("<strong>Confirm Password cannot be empty.</strong>");

                    confirmPassword = "";
                    noErrors = false;
                } else {
                    if (password.length() <= User.MINIMUM_PASSWORD_LENGTH
                            && password.length() >= User.MAXIMUM_PASSWORD_LENGTH) {
                        errorBuffer.append("<strong>Password cannot be less than ");
                        errorBuffer.append(User.MINIMUM_PASSWORD_LENGTH);
                        errorBuffer.append(" characters and more than ");
                        errorBuffer.append(User.MAXIMUM_PASSWORD_LENGTH);
                        errorBuffer.append(" characters.</strong>");

                        password = "";
                        confirmPassword = "";
                        noErrors = false;
                    }
                }
                if (noErrors) {
                    String hashedPassword = StudentDA.hashThePassword(password);

                    Student aStudent = new Student(possibleId, hashedPassword, firstName, lastName, email,
                            enrolDate, lastAccess, 's', true, programCode, programDescription, selectedYear);

                    session.setAttribute("aStudent", aStudent);

                    try {

                        // Disable auto-commit mode
                        c.setAutoCommit(false);

                        if (UserDA.create(aStudent)) {
                            if (StudentDA.create(aStudent)) {
                                c.commit();
                            } else {
                                c.rollback();
                            }

                        } else {
                            c.rollback();
                        }

                        session.setAttribute("message", "Your account has been "
                                + "successfully created.");
                        session.setAttribute("errors", "");

                        response.sendRedirect("./dashboard.jsp");

                    } catch (SQLException sqle) {

                        errorBuffer.append("Something went wrong with the database"
                                + " transaction.");
                        session.setAttribute("errors", errorBuffer.toString());
                        response.sendRedirect("./register.jsp");

                    }

                }

            } catch (NumberFormatException nfe) {

                //new code == way better, if I do say so myself
                //sending errors to the page thru the session
                errorBuffer.append("<strong>Student ID must only contain numeric "
                        + "characters, you entered: " + possibleId + ".<br/>");
                errorBuffer.append("Please try again.</strong>");
                session.setAttribute("login", "");

                session.setAttribute("errors", errorBuffer.toString());
                response.sendRedirect("./register.jsp");
            }

        } catch (Exception e) { //not connected
            System.out.println(e);
            String line1 = "<h2>A network error has occurred!</h2>";
            String line2 = "<p>Please notify your system "
                    + "administrator and check log. " + e.toString() + "</p>";
            formatErrorPage(line1, line2, response);
        }
    }

    /**
     *
     * Call the doPost method when data is obtained from the register.jsp 
     * form. 
     * 
     * @param request HTTP request
     * @param response HTTP response
     * @throws ServletException if a general exception error was encountered
     * @throws IOException if a general InputOutput error was encountered
     */
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * I'm not sure what this method does but I think it's used to print out any
     * errors to a specific format.
     *
     * @param first takes a string args
     * @param second takes a string args
     * @param response HTTP response
     * @throws IOException if a general InputOutput error was encountered
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

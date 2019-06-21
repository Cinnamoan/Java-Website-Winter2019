package webd4201.carlosi;

import java.sql.Connection;
import java.util.*;

/**
 * Main method to test the Student JDBC methods
 * 
 * @author Darren Puffer
 * @version 1.0 (2018 January 18)
 * @since 1.0
 */
public class Lab1Tester {
    
    /**
     * Used for testing the all relevant methods/attributes of the MarkDA class
     */
    static Mark aMark;
    
    /**
     *
     * Used to see if methods of certain classes work as intended.
     * 
     * @param args takes an array of strings args
     */
    public static void main(String[] args) {
		System.out.println("******************** Lab 1 Output ********************\n");
                
                /**
                 * Declare a connection object.
                 */
		Connection c = null;
                
                /**
                 * Declare a possible ID.
                 */
		long possibleId = 100222222L;
                
                /**
                 * Declare a calendar object.
                 */
		GregorianCalendar cal = new GregorianCalendar();
                
                /**
                 * Set current time for last access.
                 */
		Date lastAccess = cal.getTime();
                
                /**
                 * Set date to 2019/01/18
                 */
		cal.set(2019, Calendar.JANUARY, 18);
                
                /**
                 * Set current time for enrolled date.
                 */
		Date enrol = cal.getTime(); 
                
                /**
                 * Declare a variable to hold the vector that will be used for MarkDA.retrieveAll() method testing.
                 */
                Vector marks;
                
                /**
                 * Declare new vector and assigned it to a variable which will be used to test MarkDA.retrieveAll() testing.
                 */
                marks = new Vector();
		try{
                    Student mainStudent = new Student();  //object for a program created Student
                    //Student dbStudent = new Student();   //object for database retrieved Student
			System.out.println("\nCreate a Student user to insert/delete later in the program, passing:\n\t" +
					"Student student1 = new Student(" + possibleId + "L, \"password\", \"Robert\", \"McReady\"," +
					" \"bob.mcready@dcmail.ca\", enrol, lastAccess, 's', true, \"CPA\", \"Computer Programmer Analyst\", 3);\n"); 
			
			mainStudent = new Student(possibleId,"password", "Robert", "McReady", "bob.mcready@dcmail.ca",
					enrol, lastAccess, 's', true, "CPA", "Computer Programmer Analyst", 3);
			//mainStudent.displayToConsole();
			try{
				
                            // initialize the database (i.e. create a database connection)
                            c = DatabaseConnect.initialize();
                            User.initialize(c);
                            Student.initialize(c);
                            Mark.initialize(c);
                            
                            try // attempt to get a Student that does NOT exist, throws Exception
                            {
                                System.out.println("\nAttempt to create a student  with Id: " + possibleId + ")");
                                mainStudent.create();
                                System.out.println("Student record with id " + possibleId + " retrieved from the database\n");
        //	            	dbStudent.displayToConsole();
                                
                                long JaneDoeId = 100111110l;
                                
//                                try {
//                                    marks = Mark.retrieveAll(JaneDoeId);
//                                    for (int i = 0; i < marks.size(); i++) {
//                                        aMark = marks.get(i);
//                                        aMark.dump();
//                                    }
//                                }
                                
                            }
                            catch(DuplicateException e)
                            {	System.out.println(e.getMessage());}
                            catch (Exception ee)
                            {   System.out.println(ee.getMessage());}
                            
	            /*
	            try // attempt to get a Student that does NOT exist, throws Exception
	            {
	            	System.out.println("\nAttempt to retrieve a student that does not exist (Id: " + possibleId + ")");
	            	dbStudent = Student.retrieve(possibleId);
	            	System.out.println("Student record with id " + possibleId + " retrieved from the database\n");
//	            	dbStudent.displayToConsole();
	            }
	            catch(NotFoundException e)
	            {	System.out.println(e.getMessage());}

	            try // attempt to get a Student that does exist
	            {
	            	possibleId = 100111111L;
	            	System.out.println("\nAttempt to retrieve a student that does exist (Id: " + possibleId + ")");
	            	dbStudent = Student.retrieve(possibleId);
	            	System.out.println("Student record with id " + possibleId + " retrieved from the database\n");
//	            	dbStudent.displayToConsole();
	            }
	            catch(NotFoundException e)
	            {	System.out.println(e.getMessage());}
	            
	            try
	            {
	            	System.out.println("\nAttempt to insert a new student record for " 
	            						+ mainStudent.getFirstName() + " " + mainStudent.getLastName() 
	            						+ "(Id: " + mainStudent.getId()+")");
	            	mainStudent.create();
	                System.out.println("Student record added to the database.\n");
	            }
	            catch(DuplicateException e)
	            {	System.out.println(e);}
	            
	            try
	            {
	            	System.out.println("\nChange the student object and attempt to update the student record for " 
	            						+ mainStudent.getFirstName() + " " + mainStudent.getLastName() 
	            						+ "(Id: " + mainStudent.getId() +")");
	            	mainStudent.setPassword("newpassword");
	            	mainStudent.setProgramCode("RPN");
	            	mainStudent.setProgramDescription("Registered Practical Nurse");
	            	
	            	mainStudent.update();
	                System.out.println("Student record updated in the database.\n");
	            }
	            catch(NotFoundException e)
	            {	System.out.println(e);}
	            
	            System.out.println("\nStudents are encouraged to comment out the folowing try...catch block to"
	            		+ " verify the new record exists in pgAdmin by running the \"SELECT * FROM Students;\" command "); 
		            	
	            try // now, attempt to delete the new Student
	            {
	            	System.out.println("\nAttempt to delete the new student record for " 
	            	   						+ mainStudent.getFirstName() + " " + mainStudent.getLastName() 
   						+ "(Id: " + mainStudent.getId() + ")");
	        	   		mainStudent.delete();
	        	   	System.out.println("Student record with id " + mainStudent.getId() + " successfully removed from the database.\n");
	            }
	            catch(NotFoundException e)
	                    {	System.out.println(e);}

	            try // now, try to find the deleted Student
	            {
	            	possibleId = 100222222L;
	                mainStudent = Student.retrieve(possibleId);
//	                mainStudent.displayToConsole();
	                mainStudent.delete();
	            }
	            catch(NotFoundException e)
	            {
	            	System.out.println("Did not find student record with id " + possibleId + ".\n");
	            }*/
                }catch(Exception e){   //catch for database initialize/connect try
                         System.out.println(e.toString());
                }finally{ // close the database resources, if possible            
                 try{  Student.terminate(); }catch(Exception e){}
                 try{  DatabaseConnect.terminate(); }catch(Exception e){}
                }
	}catch(Exception iude){
			System.out.println(iude.getMessage());
		}
	}
}


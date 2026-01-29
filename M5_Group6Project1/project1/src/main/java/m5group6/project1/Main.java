
package m5group6.project1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import m5group6.project1.db.*;
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("\nM5_Group6_Project1 Library Application starting...");
        
        //Connection to Database         
        try (Connection connection = DBConnection.getConnection();)
        		
        		{
        	logger.info("Database Connected Successfuly");
       

        }catch(Exception e) {
    	e.printStackTrace();
    }

        try {
            LibraryApplication libraryApplication = new LibraryApplication();
            libraryApplication.start();
            logger.info("Application exited normally.");

        } catch (Exception ex) {
            logger.error("Fatal error occurred in main()", ex);
            System.out.println("A fatal error occurred. The program will exit.");

        } finally {
            logger.info("Main method finished execution.");
        }
    }
}


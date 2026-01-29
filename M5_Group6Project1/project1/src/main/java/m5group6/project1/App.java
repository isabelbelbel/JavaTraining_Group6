package m5group6.project1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
/**
 * Hello world!
 *
 */
public class App 
{
	private static final String URL = "jdbc:postgresql://localhost:5432/training_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
	 private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {

    	logger.info("Application started!");
        logger.error("Something went wrong!", new Exception("Test"));
        Connection connection = null;        
        try {
        	
        //Connection
        	connection = DriverManager.getConnection(URL, USER, PASSWORD);
        	System.out.println("Connected Successfully");
        	

    }catch(Exception e) {
    	e.printStackTrace();
    }

    }
}

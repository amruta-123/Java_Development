package in.main.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	//Restricting object creation
	private JdbcUtil()
	{
		
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {

		    //Take the date from properties file
			FileInputStream fileInputStream=new FileInputStream("C:\\Users\\HP\\Desktop\\Full_Stack_Java\\JDBC_App\\application.properties");
			Properties properties=new Properties();
			properties.load(fileInputStream);
			
			// Step 1: Establish the connection
			Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
			System.out.println("CONNECTION object is created!");
			return connection;
			
		
	}

	public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}

	}
}

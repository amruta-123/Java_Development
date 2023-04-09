package in.main.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import in.main.util.JdbcUtil;

public class InsertApp {
	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet=null;

		try {
			
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				statement = connection.createStatement();
			}
			if(statement!=null)
			{
				resultSet=statement.executeQuery("select sid,sname,age,saddress from student");
			}
			if(resultSet!=null)
			{
				System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
				while(resultSet.next())
				{
					System.out.printf("%-8d%-8s%-8d%-15s", resultSet.getInt(1),resultSet.getString(2), resultSet.getInt(3),resultSet.getString(4));
					System.out.println();
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, statement,resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		
	}

}

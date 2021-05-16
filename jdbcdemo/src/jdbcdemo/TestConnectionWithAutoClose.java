package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnectionWithAutoClose {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/*ARM or try with resources is used to close the connection automatically 
		instead of closing explicitly using con.close*/
	
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root"))
		{
			System.out.println("connected to hr database of mysql");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

	}

}

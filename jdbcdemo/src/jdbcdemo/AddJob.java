package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class AddJob {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root"))
		{
			//to take input from user
			Scanner s = new Scanner(System.in);
			System.out.println("Enter ID     :");
			String id = s.nextLine();//nextline-to read a line from keyboard
			System.out.println("Enter Title   :");
			String title = s.nextLine();
			System.out.println("Enter Min Sal");
			int minsal = s.nextInt();
			
			//concatinate to create a valid sql command
			String cmd = "insert into jobs values('" + id + "','" + title +"'," + minsal + ")";
			System.out.println("Executing " + cmd);
			Statement st = con.createStatement();
			st.executeUpdate(cmd);
			System.out.println("Added jobs Successsfully!");
			st.close();
			
		}
	}

}

package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class UpdateMinSalWithParams {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root"))
		{
			//to take input from user
			Scanner s = new Scanner(System.in);
			System.out.println("Enter ID     :");
			String id = s.nextLine();//nextline-to read a line from keyboard
			
			System.out.println("Enter Min Sal");
			int minsal = s.nextInt();
			
			//concatinate to create a valid sql command
			String cmd = "update jobs set minsal = ? where id = ? ";
			
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setInt(1, minsal);
			ps.setString(2, id);
			int count = ps.executeUpdate();
			if(count== 1)
			{
			    System.out.println("Updated jobs Successsfully!");
			}
			else
			{
				System.out.println("Sorry! id not found");
			}
			ps.close();
		}
	}

}

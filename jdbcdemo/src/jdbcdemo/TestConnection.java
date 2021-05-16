package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestConnection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root");
		System.out.println(con.getClass());
		System.out.println("connected to hr database of mysql");
		con.close();
	}

}

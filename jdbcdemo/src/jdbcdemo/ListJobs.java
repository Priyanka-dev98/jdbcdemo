package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListJobs {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from jobs");
		while(rs.next()) {
			System.out.printf("%-20s %8d\n", rs.getString("title"),rs.getInt("minSal"));
		}
		rs.close();
		st.close();
		con.close();

	}

}

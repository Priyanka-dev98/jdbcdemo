package jdbcdemo;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class BatchProcessDemo {

	public static void main(String[] args) throws Exception   {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root");
		con.setAutoCommit(false);
		Statement stmt = con.createStatement();
		try {
			stmt.addBatch("update employees set salary = salary + 25000 where salary <= 5000000");
			stmt.addBatch("update employees set salary = salary + 50000 where salary > 5000000");
			int[] uc = stmt.executeBatch();
			con.commit();
			for(int i=0;i<uc.length;i++) {
				System.out.println(i+":"+uc[i]);
			}
		} catch(BatchUpdateException ex) {
			System.out.println("Batch Update Exception :"+ex.getMessage());
			con.rollback();
		}
	}
	
}

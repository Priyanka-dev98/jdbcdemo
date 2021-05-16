package jdbcdemo;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
		rowSet.setUrl("jdbc:mysql://localhost:3306/hr");
		rowSet.setUsername("root");
		rowSet.setPassword("root");
		//rowSet.setCommand("select * from employees");
		rowSet.setCommand("select fullname,salary,title from employees join jobs on(employees.job = jobs.id)");
		rowSet.execute();
		while(rowSet.next()) {
			System.out.printf("%-20s %8d %-5s\n",
					rowSet.getString("fullname"),
					rowSet.getInt("Salary"),
					//rowSet.getString("job")
					rowSet.getString("title"));
		}

	}

}

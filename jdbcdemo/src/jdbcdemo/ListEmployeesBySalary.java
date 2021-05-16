package jdbcdemo;


import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetProvider;

class SalaryPredicate implements Predicate{
	private int salary;
	public SalaryPredicate(int salary) {
		this.salary = salary;
	}
	@Override
	public boolean evaluate(RowSet rs) {
		// TODO Auto-generated method stub
	try {
		//System.out.println(rs.getInt("salary"));
		return rs.getInt("salary") > this.salary;
	} catch(Exception ex) {
		return false;
	}
	}
	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}

public class ListEmployeesBySalary {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try(FilteredRowSet frs = RowSetProvider.newFactory().createFilteredRowSet()) {
			frs.setUrl("jdbc:mysql://localhost:3306/hr");
			frs.setUsername("root");
			frs.setPassword("root");
			frs.setCommand("select * from employees");
			frs.execute();
			
			Scanner s = new Scanner(System.in);
			while(true) {
				System.out.print("enter min salary [0 to stop] : ");
				int salary = s.nextInt();
				if(salary == 0)
					break;
				frs.setFilter(new SalaryPredicate(salary));
				frs.beforeFirst();
				while(frs.next()) {
					System.out.printf("%-30s %8d\n",frs.getString("fullname"),frs.getInt("salary"));
				}
			}
		}

	}

}

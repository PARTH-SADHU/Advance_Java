
package Mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BatchMain {

	public static void main(String[] args) {
		Connection con;
		Statement st;
		
		try
		{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/yourdb","root","");
			
			st=con.createStatement();
			
			
			String uQry="update student set clg='bit' where clg='Parul'";
			String iQry="insert into student(id,name,clg,sem) values('5','rrrr','Parul','6')";
			String dQry="delete from student where id='3'";
			
	
			st.addBatch(uQry);
			st.addBatch(iQry);
			st.addBatch(dQry);
			
			int[] n=st.executeBatch();
			
			for(int i=0;i<n.length;i++)
			{
				System.out.println("Row changed : "+n[i]);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}





}

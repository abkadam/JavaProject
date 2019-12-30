import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DataBase {
	public static void main(String[] args) throws SQLException {
		
		Connection con =null;
		PreparedStatement psmt;
		ResultSet rs;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver found");
			con=DriverManager.getConnection("jdbc:mysql://192.168.100.26:3306/group018","group018","welcome");
			System.out.println("connection done");
		//	psmt=con.prepareStatement("insert into Employee50 values(?,?,?)");
		//	 psmt=con.prepareStatement("delete from Employee50 where empid=?");
			 psmt=con.prepareStatement("update Employee50 set salary=? where empid=?");
		    Scanner s =new Scanner(System.in);
		    System.out.println("enter Employee id:=");
		    int i=s.nextInt();
		    //System.out.println("enter Employee name:=");
		    //String n=s.next();
		  System.out.println("enter Employee new sal:=");
		   float sal=s.nextFloat();

		    psmt.setInt(2, i);
		    //psmt.setString(2, n);
		    psmt.setFloat(1, sal);
		    int status=psmt.executeUpdate();
		    if(status>0)
		    {
		    	//System.out.println("successfully inserted");
		    	//System.out.println("deleted");
		    	System.out.println("updated");
		    }
		    else
		    {
		    	System.out.println("failed to inserted");
		    }
		    rs=psmt.executeQuery("select * from Employee50");
		    
		    while(rs.next())
		    {
		    	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
		    	
		    }
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			con.close();
		}
		
	}
	

}

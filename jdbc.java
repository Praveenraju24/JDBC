package mysql_jdbc;

import java.sql.*;
import java.util.*;

public class jdbc {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub 
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Database_name","Your_username","Your_Password");
		Statement st=con.createStatement();
		
		
	    System.out.println("Student Management System");
	    System.out.println("1.create 2.Retrieve 3.Update 4.Delete 5.Insert 6.Drop Whole data 7.truncate only data 8.Exit");
		
			
			int ch=s.nextInt();
			
		
		while(ch!=8) {
			
			switch(ch)
			{
				case 1:create_Table(st);break;
				case 2:retrieve_data(st);break;
				case 3:Update_table(st);break;
				case 4:Delete_table(st);break;
				case 5:Insert_table(st);break;
				case 6:Drop_table(st);break;
				case 7:truncate_table(st);break;
			}
	        System.out.println("1.create 2.Retrieve 3.Update 4.Delete 5.Insert 6.Drop Whole data 7.truncate only data 8.Exit");
			ch=s.nextInt();
		}	
		con.close();
	}
	public static void create_Table(Statement st) throws SQLException
	{   
		
		System.out.println("Enter table name : ");
		String table=s.next();
		
		System.out.println("Enter no of attributes :");
		int n=s.nextInt();
		
		String query="create table "+table+"(";
		
		System.out.println("Enter column name and data type separated by comma");
		
		for(int i=0;i<n-1;i++)
		{
			String str[]=s.next().split(",");
			
			if(str[1].equals("int"))
				query=query+" "+str[0]+" int(4),";
			else if(str[1].equals("float"))
				query=query+" "+str[0]+" float(4)";
			else
				query=query+" "+str[0]+" varchar(20),";
		}
		String str[]=s.next().split(",");
		
		if(str[1].equals("int"))
			query=query+" "+str[0]+" int(4))";
		else if(str[1].equals("float"))
			query=query+" "+str[0]+" float(4))";
		else
			query=query+" "+str[0]+" varchar(20))";
		
		st.executeUpdate(query);
		
		System.out.println("Table Created Successfull");
	}
	
	public static void retrieve_data(Statement st) throws SQLException
	{   
		System.out.println("Enter table name to retrieve students data");
		String table=s.next();
		
		ResultSet rs2=st.executeQuery("desc "+table);
		
		ArrayList<String> cols=new ArrayList<>();
		
		while(rs2.next())
		{
			System.out.print("| "+rs2.getString(1)+" | ");
			cols.add(rs2.getString(1));
		}
		
		System.out.println();
		
		String query="select * from "+table;
		
		ResultSet rs=st.executeQuery(query);
		
		
	    while(rs.next())
	    {
	    	for(int i=0;i<cols.size();i++)
	    	{
	    		System.out.print("| "+rs.getString(cols.get(i))+" | ");
	    	}
	    	System.out.println();
	    }
	    System.out.println("Successfully retrieved");
	}
	
	public static void Update_table(Statement st) throws SQLException
	{
		System.out.println("Enter table name : ");
		String table=s.next();
		System.out.println("Enter column name and old value ,new value to be updated separated by comma : ");
		String str[]=s.next().split(",");
		st.executeUpdate("update "+table+" set "+str[0]+"="+str[2]+" where "+str[0]+"="+str[1]);
		System.out.println("Successfully Updated");
	}
    public static void Delete_table(Statement st) throws SQLException
    {
    	System.out.println("Enter table name : ");
		String table=s.next();
		System.out.println("Enter column name and value to be deleted seperated by comma");
		String str[]=s.next().split(",");
		
		st.executeUpdate("delete from "+table+" where "+str[0]+"="+str[1]);
		System.out.println("Successfully deleted");
		
    }
    public static void Insert_table(Statement st) throws SQLException
    {
    	System.out.println("Enter table name : ");
		String table=s.next();
		System.out.println("Enter Details of the student : ");
	
	    String query="insert into "+table+" values (";
	    
	    ResultSet rs=st.executeQuery("desc "+table);
	    
	    while(rs.next())
	    {
	    	System.out.println(rs.getString(1)+" : ");
	    	String str=s.next();
	    	if(rs.getString(2).equals("varchar(20)"))
	    	{
	    		query=query+"\'"+str+"\',";
	    	}
	    	else
	    		query=query+str+",";
	    }
	    
	    query=query.substring(0,query.length()-1)+")";
	    
	    st.executeUpdate(query);
		System.out.println("Successfully Inserted");
    }
    public static void Drop_table(Statement st) throws SQLException {
    	
    	System.out.println("Enter table name : ");
    	String table=s.next();
    	
    	st.executeUpdate("drop table "+table);
    	System.out.println("Student data in "+table+" table is deleted Successfully");
    }
    public static void truncate_table(Statement st) throws SQLException {
    	
    	System.out.println("Enter table name : ");
    	String table=s.next();
    	
    	st.executeUpdate("truncate table "+table);
    	System.out.println("Student data in "+table+" is deleted Successfully but structure remains!!");
    }
}

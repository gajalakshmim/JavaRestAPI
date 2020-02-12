package com.akshabi.firstrest;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
	
	List<Alien> myaliens;
	
	public AlienRepository() {
		myaliens = new ArrayList<>();
		try {
			myaliens = makelist();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("");
			e.printStackTrace();
		}
		
	} 
	private List<Alien> makelist() throws SQLException  {
		List<Alien> makingaliens;
		makingaliens=new ArrayList<>();
		
		
		String url="jdbc:sqlserver://localhost:55407;" + "databaseName=sortdb";
		String user="admin";
		String pwd="admin";
		String query = "SELECT * FROM Employee";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection(url, user, pwd);
		
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			Alien a1=new Alien();
		
		String name= rs.getString("FirstName");
		Integer age=rs.getInt(4);
		a1.setName(name);
		a1.setPoints(age);
		makingaliens.add(a1);
		}
	    con.close();
		st.close();
		return makingaliens;
	}
	
	public List<Alien> getAliens(){
		return myaliens;
	}
	
	public Alien getAlien(int id) {
		for(Alien a:myaliens) {
			if(a.getPoints()==id)
				return a;
		}
		return new Alien();
	}

	public void create(Alien b) throws Exception{
		// TODO Auto-generated method stub
	myaliens.add(b);
	
		String url="jdbc:sqlserver://localhost:55407;" + "databaseName=sortdb";
		String user="admin";
		String pwd="admin";
		String query = "insert into employee(firstname,empid) values(?,?)";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(url, user, pwd);
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, b.getName());
		//st.setString(2,"Bose");
		//st.setLong(3, 12345);
		st.setInt(2,b.getPoints());
		int count=st.executeUpdate();
		
		System.out.println("the total number of rows affted "+count);
		/*while(rs.next()) {
		String name= rs.getString("FirstName");
		System.out.println(name);
		}*/
		st.close();
		con.close();
	
	
	}

	
	

}

package com.CucumberProject.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DBConnectivity {


	private static final String URL = "jdbc:mysql://localhost:3306/sakila";
	private static final String user = "Hariharan";
	private static final String password = "Iamgroot";
	
	private static Connection con;
	private static Statement statement;
	private static ResultSet rs;
	private static PreparedStatement pre;
	
	public static void getrow() throws SQLException
	{
		String query = "select * from actor";
		
		try
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			con = DriverManager.getConnection(URL, user, password);
			statement = con.createStatement();
			rs =statement.executeQuery(query);
			while (rs.next()) {
				System.out.print(rs.getString("first_name"));
				System.out.print(" ");
				System.out.print(rs.getString("last_name"));
				System.out.print(" ");
//				System.out.print(rs.getString("Email"));
//				System.out.print(" ");
				System.out.println("\n");
//				System.out.print(rs.getString("author"));
//				System.out.print(" ");
//				System.out.print(rs.getString("ed_num"));
//				System.out.print(" ");
//				System.out.print(rs.getString("price"));
//				System.out.print(" ");
//				System.out.print(rs.getString("pages"));
//				System.out.println("\n");
				
			}
		
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			con.close();
			rs.close();
			statement.close();
			
			
		}
	}
	
	public static void deleterow() throws SQLException
	{
        String query = "DELETE FROM emp1 where empid=111";
		
		try
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			con = DriverManager.getConnection(URL, user, password);
			statement = con.createStatement();
			int data =statement.executeUpdate(query);
				if(data==1)
				{
					System.out.println("ROW Deleted Successfully!");
				}
				else
				{
					System.out.println("ROW Exisits!");
				}
			
				
		
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			con.close();
			//rs.close();
			statement.close();
			
			
		}
	}

	
	public static void Insertrow() throws SQLException
	{
        String query = "insert into emp1 values(?,?,?)";
        String query1 = "UPDATE emp1 SET salary = ? WHERE empid = ?";
		
		try
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			con = DriverManager.getConnection(URL, user, password);
			pre = con.prepareStatement(query1);
			statement = con.createStatement();
			
			Scanner input = new Scanner(System.in);	
            
            System.out.print("Enter the empid:  ");
            int eid = input.nextInt();
            System.out.println();
            
            System.out.print("Enter the employee salary:  ");
            String esal = input.next();
            System.out.println();
//            
//            System.out.print("Enter the employee name:  ");
//            String ename = input.next();
//            System.out.println();
//            
            pre.setInt(2, eid);
//            pre.setString(2, ename);
            pre.setString(1, esal);
			int data =pre.executeUpdate();
				if(data==1)
				{
					System.out.println("ROW Inserted Successfully!");
				}
				else
				{
					System.out.println("Error! Row cannot be Inserted");
				}
			
				
		
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			con.close();
			//rs.close();
			statement.close();
			
			
		}
	}
	public static void main(String[] args) throws SQLException {
		getrow();
		//deleterow();
		//Insertrow();
	}

}

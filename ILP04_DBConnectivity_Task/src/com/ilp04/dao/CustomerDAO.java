package com.ilp04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp04.entity.Customer;

public class CustomerDAO {
	
	//get connection
		public static Connection getConnection()
		{
			String connectionURL = "jdbc:mysql://localhost:3306/bankdb?useSSL=false";
			String userName = "root";
			String password = "experion@123";
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(connectionURL, userName, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return connection;
		}
	//close connection
		public Connection closeConnection(Connection connection)
		{
			try
			{
				connection.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return connection;
		}
	//get customer details
		public static ArrayList <Customer> getAllCustomers(Connection connection)
		{
			ArrayList<Customer> customerList = new ArrayList<Customer>();
			Statement statement;
			ResultSet resultSet;
			
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select * from customer");
				while(resultSet.next())
				{
					int customerCode = resultSet.getInt(1);
					String customer_FirstName = resultSet.getString(2);
					String customer_LastName = resultSet.getString(3);
					String address = resultSet.getString(4);
					long phoneNo = resultSet.getLong(5);
					long aadharNo = resultSet.getLong(6);
					Customer customer = new Customer(customerCode, customer_FirstName, customer_LastName, address, phoneNo, aadharNo);
					customerList.add(customer);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return customerList;
		}
		
		public static int updateCustomer(Connection connection, Customer customer)
		{
			int result =0;
			
			try {
				int customerCode = customer.getCustomerCode();
				String fname = customer.getCustomerFirstname();
				String lname = customer.getCustomerLastName();
				String address = customer.getAddress();
				long pNo = customer.getPhoneNo();
				long aadhar = customer.getAadharNo();
				
				String query = "update customer set customer_firstname = ?, customer_lastname = ?, customer_address = ?, phone_no = ?, aadhar_no = ? where customer_code = ?";
				PreparedStatement prepareStatement = connection.prepareStatement(query);
				prepareStatement.setString(1, fname);
				prepareStatement.setString(2, lname);
				prepareStatement.setString(3, address);
				prepareStatement.setLong(4, pNo);
				prepareStatement.setLong(5, aadhar);
				prepareStatement.setInt(6, customerCode);
				result = prepareStatement.executeUpdate();
				
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			
			}
			
			return result;
		}
		
		public static int insertCustomer(Connection connection,Customer customer)
		{	
			int result = 0;
			
			try {
				String fname = customer.getCustomerFirstname();
				String lname = customer.getCustomerLastName();
				String address = customer.getAddress();
				long pNo = customer.getPhoneNo();
				long aadhar = customer.getAadharNo();
				
				String query = "insert into customer(customer_firstname, customer_lastname, customer_address,phone_no, aadhar_no) values(?,?,?,?,?)";
				PreparedStatement prepareStatement = connection.prepareStatement(query);
				prepareStatement.setString(1, fname);
				prepareStatement.setString(2, lname);
				prepareStatement.setString(3, address);
				prepareStatement.setLong(4, pNo);
				prepareStatement.setLong(5, aadhar);
				result = prepareStatement.executeUpdate();
				
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			
			}
			return result;
		}
}

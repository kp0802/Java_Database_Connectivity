package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.CustomerDAO;
import com.ilp04.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public ArrayList<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		Connection connection = CustomerDAO.getConnection();
		customerList = CustomerDAO.getAllCustomers(connection);
		
		return customerList;
	}

	@Override
	public int insertIntoCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Connection connection = CustomerDAO.getConnection();
		int result = CustomerDAO.insertCustomer(connection, customer);
		if(result ==1)
		{
			System.out.println("Successful");
		}
		else
		{
			System.out.println("Transaction failed!");
		}
		return 0;
	}

	@Override
	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Connection connection = CustomerDAO.getConnection();
		int result = CustomerDAO.updateCustomer(connection, customer);
		if(result ==1)
		{
			System.out.println("Successful");
		}
		else
		{
			System.out.println("Transaction failed!");
		}
		return 0;
	}

}

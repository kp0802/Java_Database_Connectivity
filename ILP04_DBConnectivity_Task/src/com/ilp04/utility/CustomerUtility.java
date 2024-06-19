package com.ilp04.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;

public class CustomerUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 1;
		int choice;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter: 1) Display All Customers 2)Insert a New Customer 3)Update a New Customer");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1: getAllCustomers();
				break;
			case 2:  newCustomer();           //insertCustomer();
				break;
			case 3: updateCustomerDetails();
				break;
			default: System.out.println("Invalid choice!");	
				
			}
			System.out.println("Do you want to continue? Enter 1 if yes and 0 if no: ");
			count = sc.nextInt();
		}
		while(count==1);
	}

	private static void updateCustomerDetails() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		CustomerService customerService = new CustomerServiceImpl();
		
		int customer_code;
		String fName, lName, address;
		long pNo, aadharNo;
		System.out.println("Enter Customer Code: ");
		customer_code = sc.nextInt();
		System.out.println("Enter Customer's First Name: ");
		sc.nextLine();
		fName = sc.nextLine();
		System.out.println("Enter Customer's Last Name: ");
		lName = sc.nextLine();
		System.out.println("Enter Customer's Address: ");
		address = sc.nextLine();
		System.out.println("Enter Customer's Phone No: ");
		pNo = sc.nextLong();
		System.out.println("Enter Customer's Aadhar No: ");
		aadharNo = sc.nextLong();
		Customer customer = new Customer(customer_code,fName, lName, address, pNo, aadharNo);
		customerService.updateCustomer(customer);
	}

	private static void newCustomer() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		CustomerService customerService = new CustomerServiceImpl();
		
		String fName, lName, address;
		long pNo, aadharNo;
		System.out.println("Enter Customer's First Name: ");
		fName = sc.nextLine();
		System.out.println("Enter Customer's Last Name: ");
		lName = sc.nextLine();
		System.out.println("Enter Customer's Address: ");
		address = sc.nextLine();
		System.out.println("Enter Customer's Phone No: ");
		pNo = sc.nextLong();
		System.out.println("Enter Customer's Aadhar No: ");
		aadharNo = sc.nextLong();
		Customer customer = new Customer(fName, lName, address, pNo, aadharNo);
		customerService.insertIntoCustomer(customer);
	}

	private static void getAllCustomers() {
		// TODO Auto-generated method stub
		CustomerService customerService = new CustomerServiceImpl();
		ArrayList<Customer> customerList = customerService.getAllCustomers();
		//print the result
		System.out.println("Customer Code\tCustomer First Name\tCustomer Last Name\tAddress\tPhone No\tAadhar No");
		for(Customer customer : customerList)
		{
			System.out.println(customer.getCustomerCode() + "\t\t" + customer.getCustomerFirstname()+ "\t\t" + customer.getCustomerLastName()+ "\t\t" + customer.getAddress() + "\t\t" + customer.getPhoneNo() + "\t\t" + customer.getAadharNo());
		}
	}

}

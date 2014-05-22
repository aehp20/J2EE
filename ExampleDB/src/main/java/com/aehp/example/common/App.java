package com.aehp.example.common;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aehp.example.dao.CustomerDAO;
import com.aehp.example.domain.Customer;

public class App 
{
	private static ApplicationContext context;

    public static void main( String[] args )
    {
    	context = new ClassPathXmlApplicationContext("Spring-Module.xml");

        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");

//        Customer newCustomer = new Customer(3,"mkyong",28);
//        customerDAO.insert(newCustomer);

        //Customer customer1 = customerDAO.findByCustomerId(1);

    	List<Customer> customers = customerDAO.findByCustomers();
    	for(Customer customer: customers) {
    		System.out.println(customer);
    	}

    }
}
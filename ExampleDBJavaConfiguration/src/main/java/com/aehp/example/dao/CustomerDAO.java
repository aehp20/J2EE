package com.aehp.example.dao;

import java.util.List;
import java.util.Map;

import com.aehp.example.domain.Customer;;

public interface CustomerDAO 
{
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
	public List<Map<String,Object>> findByCustomers();
}

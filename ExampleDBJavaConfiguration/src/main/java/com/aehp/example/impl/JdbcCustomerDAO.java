package com.aehp.example.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aehp.example.dao.CustomerDAO;
import com.aehp.example.domain.Customer;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class JdbcCustomerDAO implements CustomerDAO {
	// private DataSource dataSource;
	//
	// public void setDataSource(DataSource dataSource) {
	// this.dataSource = dataSource;
	// }

//	private SessionFactory sessionFactory;
//
//	@Autowired
//	public JdbcCustomerDAO(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	@Transactional(readOnly = false)
	public void insert(Customer customer) {

		System.out.println("ok");
	}

	@Transactional(readOnly = true)
	public Customer findByCustomerId(int custId) {

		return null;
	}

	@Transactional(readOnly = true)
	public List<Map<String,Object>> findByCustomers() {

		String query = "select cust_id, name, age from Customer";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Map<String,Object>> customers = jdbcTemplate.queryForList(query);

		return customers;
	}

//	protected Session getCurrentSession() {
//		return sessionFactory.getCurrentSession();
//	}

}
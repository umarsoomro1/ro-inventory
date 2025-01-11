package com.project.roinventory.dao;

import com.project.roinventory.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String addCustomer(String name, String contactInfo, String address, String email) {
        String sql = "{call AddCustomer(?, ?, ?, ?)}";
        jdbcTemplate.update(sql, name, contactInfo, address, email);
        return "Customer added successfully.";
    }

    public Customer getCustomerById(int customerId) {
        String sql = "SELECT * FROM Customers WHERE Customer_ID = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Customer.class), customerId);
    }

    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM Customers";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    // Function to get total customers
    public int getTotalCustomers() {
        String sql = "SELECT GetTotalCustomers()";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    // Method to delete a customer by ID
    public int deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE Customer_ID = "+id;
        return jdbcTemplate.update(sql);
    }

    // Method to update a customer's details
    public int updateCustomer(int id, String name, String contactInfo, String address, String email) {
        String sql = "{CALL UpdateCustomer(?, ?, ?, ?, ?)}";
        return jdbcTemplate.update(sql, id, name, contactInfo, address, email);
    }
}

package com.project.roinventory.service;

import com.project.roinventory.dao.CustomerDAO;
import com.project.roinventory.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    public String addCustomer(String name, String contactInfo, String address, String email) {
        return customerDAO.addCustomer(name, contactInfo, address, email);
    }

    public Customer getCustomerById(int customerId) {
        return customerDAO.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public int getTotalCustomers() {
        return customerDAO.getTotalCustomers();
    }

    // Method to update customer
    public boolean updateCustomer(int id, String name, String contactInfo, String address, String email) {
        int result = customerDAO.updateCustomer(id, name, contactInfo, address, email);
        return result > 0;
    }

    // Method to delete customer
    public boolean deleteCustomer(int id) {
        int result = customerDAO.deleteCustomer(id);
        return result > 0;
    }
}

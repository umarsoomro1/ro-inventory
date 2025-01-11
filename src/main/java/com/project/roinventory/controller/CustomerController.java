package com.project.roinventory.controller;

import com.project.roinventory.service.CustomerService;
import com.project.roinventory.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestParam String name, @RequestParam String contactInfo,
                                              @RequestParam String address, @RequestParam String email) {
        String message = customerService.addCustomer(name, contactInfo, address, email);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/total-customers")
    public ResponseEntity<Integer> getTotalCustomers() {
        int totalCustomers = customerService.getTotalCustomers();
        return ResponseEntity.ok(totalCustomers);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable int id,
                                                 @RequestBody Customer customer) {
        boolean isUpdated = customerService.updateCustomer(id, customer.getName(),
                customer.getContactInfo(), customer.getAddress(), customer.getEmail());
        if (isUpdated) {
            return ResponseEntity.ok("Customer updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update customer");
        }
    }

    // Endpoint to delete a customer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        boolean isDeleted = customerService.deleteCustomer(id);
        if (isDeleted) {
            return ResponseEntity.ok("Customer deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete customer");
        }
    }
}

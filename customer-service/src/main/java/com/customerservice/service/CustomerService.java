package com.customerservice.service;

import com.customerservice.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Integer id);
    Customer save (Customer customer);
    void delete(Integer id);
}

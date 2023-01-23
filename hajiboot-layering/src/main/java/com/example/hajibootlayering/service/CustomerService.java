package com.example.hajibootlayering.service;

import com.example.hajibootlayering.domain.Customer;
import com.example.hajibootlayering.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
  @Autowired
  CustomerRepository customerRepository;

  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }

  public List<Customer> findAll() {
    return customerRepository.findAll();
  }
}

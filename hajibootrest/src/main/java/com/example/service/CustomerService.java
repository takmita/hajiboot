package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

import java.util.Optional;

@Service
@Transactional
public class CustomerService {
  @Autowired
  CustomerRepository customerRepository;

  public Page<Customer> findAll(Pageable pageable) {
    return (Page<Customer>) customerRepository.findAllOrderByName(pageable);
  }
  public Optional<Customer> findOne(Integer id) {
    return customerRepository.findById(id);
  }
  public Customer create(Customer customer) {
    return customerRepository.save(customer);
  }
  public Customer update(Customer customer) {
    return customerRepository.save(customer);
  }
  public void delete(Integer id) {
    customerRepository.deleteById(id);
  }
}

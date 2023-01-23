package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
  @Autowired
  CustomerService customerService;

  @GetMapping
  List<Customer> getCustomers() {
    List<Customer> customers = customerService.findAll();
    return customers;
  }
  @GetMapping(path = "{id}")
  Optional<Customer> getCustomer(@PathVariable Integer id) {
    Optional<Customer> customer = customerService.findOne(id);
    return customer;
  }
}

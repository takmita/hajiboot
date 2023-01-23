package com.example.api;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
  @Autowired
  CustomerService customerService;

  @GetMapping
  Page<Customer> getCustomers(@PageableDefault Pageable pageable) {
    Page<Customer> customers = customerService.findAll(pageable);
    return  customers;
  }

  @GetMapping(path = "{id}")
  Optional<Customer> getCustomer(@PathVariable Integer id) {
    Optional<Customer> customer = customerService.findOne(id);
    return customer;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  Optional<Customer> postCustomers(@RequestBody Customer customer) {
    return Optional.ofNullable(customerService.create(customer));
  }

  @PutMapping(path = "{id}")
  Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
    customer.setId(id);
    return  customerService.update(customer);
  }

  @DeleteMapping(path = "{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteCustomer(@PathVariable Integer id) {
    customerService.delete(id);
  }
}

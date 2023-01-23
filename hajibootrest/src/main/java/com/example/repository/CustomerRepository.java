package com.example.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.domain.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
  @Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
  List<Customer> findAllOrderByName(Pageable pageable);
}

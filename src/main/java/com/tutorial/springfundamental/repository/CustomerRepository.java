package com.tutorial.springfundamental.repository;

import com.tutorial.springfundamental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}

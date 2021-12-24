package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer addCustomer(Customer customer);

    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer getOwnerByPet(Long id);

}

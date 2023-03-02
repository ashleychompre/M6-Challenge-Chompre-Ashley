package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return repo.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        Optional<Customer> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @GetMapping("/customers/{state}")
    public List<Customer> getCustomerByState(@PathVariable String state) {
        return repo.findByState(state);
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        repo.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
    }
}

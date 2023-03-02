package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() {
        customerRepo.deleteAll();
    }

    @Test
    public void addCustomer() {
        Customer customer = new Customer();

        customer.setFirst_name("John");
        customer.setLast_name("Smith");
        customer.setEmail("john.smith@gmail.com");
        customer.setPhone("9198292929");
        customer.setAddress1("315 Towerview Road");
        customer.setAddress2("Apartment C15");
        customer.setCity("Durham");
        customer.setState("NC");
        customer.setPostalCode(27708);
        customer.setCompany("Student");

        customerRepo.save(customer);

        Customer fromRepo = customerRepo.findById(customer.getId()).get();
        assertEquals(customer, fromRepo);
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();

        customer.setFirst_name("John");
        customer.setLast_name("Smith");
        customer.setEmail("john.smith@gmail.com");
        customer.setPhone("9198292929");
        customer.setAddress1("315 Towerview Road");
        customer.setAddress2("Apartment C15");
        customer.setCity("Durham");
        customer.setState("NC");
        customer.setPostalCode(27708);
        customer.setCompany("Student");

        customerRepo.save(customer);

        // changing name and email
        customer.setFirst_name("Jack");
        customer.setEmail("jack.smith@gmail.com");

        customerRepo.save(customer);

        Customer fromRepo = customerRepo.findById(customer.getId()).get();
        assertEquals(customer, fromRepo);
    }

    @Test
    public void deleteCustomer() {
        Customer customer = new Customer();

        customer.setFirst_name("John");
        customer.setLast_name("Smith");
        customer.setEmail("john.smith@gmail.com");
        customer.setPhone("9198292929");
        customer.setAddress1("315 Towerview Road");
        customer.setAddress2("Apartment C15");
        customer.setCity("Durham");
        customer.setState("NC");
        customer.setPostalCode(27708);
        customer.setCompany("Student");

        customerRepo.save(customer);

        customerRepo.deleteCustomer(customer.getId());

        customerRepo.save(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }


}
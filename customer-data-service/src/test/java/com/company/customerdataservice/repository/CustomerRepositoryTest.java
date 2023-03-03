package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

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
    public void shouldGetCustomerByID() {
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

        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldGetCustomerByState() {
        Customer customer1 = new Customer();

        customer1.setFirst_name("John");
        customer1.setLast_name("Smith");
        customer1.setEmail("john.smith@gmail.com");
        customer1.setPhone("9198292929");
        customer1.setAddress1("315 Towerview Road");
        customer1.setAddress2("Apartment C15");
        customer1.setCity("Durham");
        customer1.setState("NC");
        customer1.setPostalCode(27708);
        customer1.setCompany("Student");

        customerRepo.save(customer1);

        List<Customer> customerinNC = new ArrayList<Customer>();
        customerinNC.add(customer1);

        List<Customer> customers = customerRepo.findByState(customer1.getState());
        assertEquals(customerinNC, customers);
    }
    @Test
    public void shouldAddCustomer() {
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

        customerRepo.addCustomer(customer);

        Optional<Customer> fromRepo = customerRepo.findById(customer.getId());
        assertEquals(customer, fromRepo.get());
    }

    @Test
    public void shouldUpdateCustomer() {
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

        customerRepo.updateCustomer(customer);

        Optional<Customer> fromRepo = customerRepo.findById(customer.getId());
        assertEquals(customer, fromRepo.get());
    }

    @Test
    public void shouldDeleteCustomer() {
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

        customerRepo.deleteCustomer(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }




}
package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of records for testing purposes
    private List<Customer> customerList;

    @Before
    public void setUp() {
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
    }

    // Testing GET /customers/{id}
    @Test
    public void shouldReturnCustomersByID() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(customerList);

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
        customer.setId(1);
        // ACT
        mockMvc.perform(get("/customers/1"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }
    
    // Testing GET /customers/{state}
    @Test
    public void shouldReturnCustomersByState() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(customerList);

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
        customer.setId(1);
        // ACT
        mockMvc.perform(get("/customers/NC"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    // Testing PUT /customers
    @Test
    public void shouldUpdateCustomerAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

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

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(put("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    // Testing POST /customers
    @Test
    public void shouldAddCustomerAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

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

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(post("/customers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing DELETE /customers
    @Test
    public void shouldDeleteCustomerAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/customers"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }



}
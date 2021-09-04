package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
class CustomerServiceTest {

    private CustomerService underTest;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setup(){
        underTest = new CustomerService(customerRepository);

    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {

        //given
        Customer customer = new Customer(1L,
                "Kushal Puri",
                "1234",
                "kushal@gmail.com");

        Customer customer2 = new Customer(2L,
                "Maira Puri",
                "1234",
                "maira@gmail.com");


        customerRepository.saveAll(Arrays.asList(customer,customer2));

        //when
        List<Customer> customers = underTest.getCustomers();


        //then
        assertEquals(2,customers.size());


    }

    @Test
    void getCustomer() {
    }
}
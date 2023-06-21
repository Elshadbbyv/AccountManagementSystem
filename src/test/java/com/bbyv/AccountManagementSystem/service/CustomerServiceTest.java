package com.bbyv.AccountManagementSystem.service;

import com.bbyv.AccountManagementSystem.dto.CustomerDto;
import com.bbyv.AccountManagementSystem.dto.converter.CustomerDtoConverter;
import com.bbyv.AccountManagementSystem.exception.CustomerNotFoundException;
import com.bbyv.AccountManagementSystem.model.Customer;
import com.bbyv.AccountManagementSystem.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class CustomerServiceTest {
     private CustomerService customerService;
     private  CustomerRepository customerRepository;
     private CustomerDtoConverter converter;

     @BeforeEach
    public void setUp(){
         customerRepository = mock(CustomerRepository.class);
         converter = mock(CustomerDtoConverter.class);
         customerService = new CustomerService(customerRepository, converter);

     }
     @Test
    public  void  testFindByCustomerId_whenCustomerIdExist_shouldThrowCustomerNotFoundException(){
         Customer customer  = new Customer("id","name","surname", Set.of());

         Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));

         Customer result = customerService.findById("id");

         assertEquals(result, customer);


     }
     @Test
    public  void testFindById_whenCustomerIdExist_shouldThrowCustomerNotFoundException(){

         Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());


         assertThrows(CustomerNotFoundException.class,
                 () -> customerService.findById("id"));


     }
    @Test
    public  void testGetCustomerById_whenCustomerIdExist_shouldReturnCustomer(){
        Customer customer  = new Customer("id","name","surname", Set.of());
        CustomerDto customerDto = new CustomerDto("id","name","surname",Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Mockito.when(converter.convertToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto result = customerService.getCustomerById("id");
        assertEquals(result, customerDto);
    }
    @Test
    public  void testGetCustomerById_whenCustomerIdExist_shouldThrowCustomerNotFoundException(){


        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class,
                ()->customerService.getCustomerById("id"));

        Mockito.verifyNoInteractions(converter);

    }



 }
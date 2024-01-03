package com.tutorial.springfundamental.service;

import com.tutorial.springfundamental.dto.CustomerRecord;
import com.tutorial.springfundamental.exception.InvalidException;
import com.tutorial.springfundamental.model.Customer;
import com.tutorial.springfundamental.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;
    @Captor
    ArgumentCaptor<Customer> customerCaptor;
    @Test
    void testGetCustomerById(){
        // given
        var customerId = UUID.fromString("3c257327-0852-4eae-a2d2-5922614c2fb6");

        var customer = new Customer();
        customer.setId(customerId);
        customer.setUsername("MonikaRai");
        customer.setPassword("KfCunu4i");
        customer.setEmail("KaiQiu@gmail.com");
        customer.setDateOfBirth(Date.from(new Date().toInstant()));

        // when
        when(customerRepository.findById(any(UUID.class))).thenReturn(Optional.of(customer));

        var actual = customerService.getCustomerById(UUID.randomUUID().toString());

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo(customerId);

        verify(customerRepository, times(1)).findById(any(UUID.class));
    }
    @Test
    void testSaveCustomer(){
        //give
        CustomerRecord request = new CustomerRecord("johndoe", "KfCunu4i", "johndoe@example.com","1997-01-03");

        //when
        when(customerRepository.save(any(Customer.class))).thenReturn(new Customer());

         Customer actual =customerService.saveCustomer(request);

        //ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);


        verify(customerRepository).save(customerCaptor.capture());

        Customer capturedCustomer = customerCaptor.getValue();
        assertThat(request.username()).isEqualTo(capturedCustomer.getUsername());
        assertThat(request.password()).isEqualTo(capturedCustomer.getPassword());
        assertThat(request.email()).isEqualTo(capturedCustomer.getEmail());

    }
    @Test
    void testSaveCustomerException(){
        CustomerRecord request = new CustomerRecord("johndoe", "password", "johndoe@example.com","2024-01-03");
        assertThatThrownBy(()->customerService.saveCustomer(request))
                .isInstanceOf(InvalidException.class)
                .hasMessageContaining("Failed to create user");

    }
}

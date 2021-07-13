package com.example.debezium.demo.service;

import com.example.debezium.demo.entities.Customer;
import com.example.debezium.demo.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.springframework.stereotype.Service;
import io.debezium.data.Envelope.Operation;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void replicateData(Map<String, Object> customerData, Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        final Customer customer = mapper.convertValue(customerData, Customer.class);

        if (Operation.DELETE == operation) {
            customerRepository.deleteById(customer.getId());
        } else {
            customerRepository.save(customer);
        }
    }
}

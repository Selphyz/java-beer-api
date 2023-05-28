package com.example.demo.mappers;

import com.example.demo.model.CustomerDTO;
import com.example.demo.model.entities.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDTOToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDTO(Customer customer);
}

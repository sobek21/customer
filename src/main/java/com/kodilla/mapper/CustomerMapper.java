package com.kodilla.mapper;

import com.kodilla.model.Customer;
import com.kodilla.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  CustomerDto mapToCustomerDto(Customer customer);

}

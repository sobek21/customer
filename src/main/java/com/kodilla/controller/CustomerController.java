package com.kodilla.controller;

import com.kodilla.mapper.CustomerMapper;
import com.kodilla.model.Customer;
import com.kodilla.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RefreshScope
@RestController
@RequestMapping
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerMapper customerMapper;

  @Value("${application.allow-get-accounts}")
  private boolean allowGetAccounts;


  @GetMapping("/customer/{idCustomer}")
  public CustomerDto getAccounts(@PathVariable long idCustomer) {
    if(!allowGetAccounts) {
      log.info("Getting accounts is disabled");
      throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
    }
    Customer customer = new Customer();
    return customerMapper.mapToCustomerDto(customer);
  }

}

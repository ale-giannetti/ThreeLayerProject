package it.unikey.esercizioconnessionelibrary.PL.controller;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.CustomerDTO;
import it.unikey.esercizioconnessionelibrary.BLL.mapper.CustomerMapper;
import it.unikey.esercizioconnessionelibrary.BLL.service.impl.CustomerServiceImpl;
import it.unikey.esercizioconnessionelibrary.PL.mapper.CustomerRestMapper;
import it.unikey.esercizioconnessionelibrary.PL.rest.CustomerRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServiceImpl service;
    private final CustomerRestMapper customerRestMapper;

    @GetMapping
    private ResponseEntity<Set<CustomerRest>> getAllCustomer(){
        Set<CustomerDTO> customerDTOS = service.getAll();
       return new ResponseEntity<>(customerDTOS.stream()
               .map(customerRestMapper::fromCustmerDtoToCustomerRest).collect(Collectors.toSet()), HttpStatus.OK);
    }
}


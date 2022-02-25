package it.unikey.esercizioconnessionelibrary.PL.controller;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.CustomerDTO;
import it.unikey.esercizioconnessionelibrary.BLL.exception.NotFoundException;
import it.unikey.esercizioconnessionelibrary.BLL.service.impl.CustomerServiceImpl;
import it.unikey.esercizioconnessionelibrary.PL.mapper.CustomerRestMapper;
import it.unikey.esercizioconnessionelibrary.PL.rest.CustomerRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServiceImpl service;
    private final CustomerRestMapper customerRestMapper;

    @GetMapping
    private ResponseEntity<Set<CustomerRest>> getAllCustomer() {
        Set<CustomerDTO> customerDTOS = service.getAll();
        return new ResponseEntity<>(customerDTOS.stream()
                .map(customerRestMapper::fromCustmerDtoToCustomerRest).collect(Collectors.toSet()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<CustomerRest> getRestById(@PathVariable("id") Integer id) {
        try {
            CustomerDTO dto = service.getById(id);
            return new ResponseEntity<>(customerRestMapper.fromCustmerDtoToCustomerRest(dto), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = {"/surname"})
    private ResponseEntity<Set<CustomerRest>> getRestBySurname(@RequestParam("surname") String surname) {
        try {
            Set<CustomerDTO> dto = service.getBySurname(surname);
            return new ResponseEntity<>(dto.stream()
                    .map(customerRestMapper::fromCustmerDtoToCustomerRest)
                    .collect(Collectors.toSet()), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/fullname")
    private ResponseEntity<Set<CustomerRest>> getRestByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname) {
        try {
            Set<CustomerDTO> dto = service.getByNameAndSurame(name, surname);
            return new ResponseEntity<>(dto.stream()
                    .map(customerRestMapper::fromCustmerDtoToCustomerRest)
                    .collect(Collectors.toSet()), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    private ResponseEntity<CustomerRest> postCustomer(@RequestBody CustomerRest customer) {
        if (customer.getId() != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        CustomerDTO dtoInsert = service.insert(customerRestMapper.fromCustomerRestToCustomerDto(customer));
        return new ResponseEntity<>(customerRestMapper.fromCustmerDtoToCustomerRest(dtoInsert), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<CustomerRest> putCustomer(@RequestBody CustomerRest customerRest) {
        try {
            CustomerDTO customerUpdate = service.update(customerRestMapper.fromCustomerRestToCustomerDto(customerRest));
            return new ResponseEntity<>(customerRestMapper.fromCustmerDtoToCustomerRest(customerUpdate), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}


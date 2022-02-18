package it.unikey.esercizioconnesionilibrary.BLL.service.impl;

import it.unikey.esercizioconnesionilibrary.BLL.DTO.CustomerDTO;
import it.unikey.esercizioconnesionilibrary.BLL.exception.NotFoundException;
import it.unikey.esercizioconnesionilibrary.BLL.mapper.CustomerMapper;
import it.unikey.esercizioconnesionilibrary.BLL.service.CrudService;
import it.unikey.esercizioconnesionilibrary.DAL.entity.CustomerEntity;
import it.unikey.esercizioconnesionilibrary.DAL.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CrudService<CustomerDTO> {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO insert(CustomerDTO entity) {

        /*CustomerEntity entityMapped = customerMapper.fromCustomerDTOToCustomerEntity(entity);
        CustomerEntity entitySaved = customerRepository.save(entityMapped);
        CustomerDTO dtoSaved = customerMapper.fromCustomerEntityToCustomerDTO(entitySaved);
        return dtoSaved;*/

        return customerMapper
                .fromCustomerEntityToCustomerDTO(customerRepository
                    .save(customerMapper
                        .fromCustomerDTOToCustomerEntity(entity))
                );
    }

    @Override
    public CustomerDTO getById(Integer id) throws NotFoundException {
        if(!customerRepository.existsById(id)){
            throw new NotFoundException("The customer you're trying to get not found in DB");
        }
        /*
        customerEntity entity = customerRepository.getById(id);
        return customerMapper.fromCustomerEntityToCustomerDTO(entity);
        */
        return customerMapper.fromCustomerEntityToCustomerDTO(customerRepository.getById(id));
    }

    @Override
    public Set<CustomerDTO> getAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::fromCustomerEntityToCustomerDTO).collect(Collectors.toSet());
    }

    @Override
    public CustomerDTO update(CustomerDTO entity) throws NotFoundException {
        if(!customerRepository.existsById(entity.getId())){
            throw new NotFoundException("The customer you're trying to update not found in DB");
        }
        CustomerEntity employeeUpdated = customerRepository.save(customerMapper.fromCustomerDTOToCustomerEntity(entity));
        return customerMapper.fromCustomerEntityToCustomerDTO(employeeUpdated);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if(!customerRepository.existsById(id)){
            throw new NotFoundException("The customer you're trying to delete not found in DB");
        }
        customerRepository.deleteById(id);
    }


}


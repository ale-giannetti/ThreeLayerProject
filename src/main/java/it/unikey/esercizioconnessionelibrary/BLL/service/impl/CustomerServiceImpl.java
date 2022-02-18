package it.unikey.esercizioconnessionelibrary.BLL.service.impl;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.CustomerDTO;
import it.unikey.esercizioconnessionelibrary.BLL.exception.NotFoundException;
import it.unikey.esercizioconnessionelibrary.BLL.mapper.CustomerMapper;
import it.unikey.esercizioconnessionelibrary.BLL.service.CrudService;
import it.unikey.esercizioconnessionelibrary.DAL.entities.CustomerEntity;
import it.unikey.esercizioconnessionelibrary.DAL.repository.CustomerRepository;
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
        return customerMapper.fromCustomerEntityToCustomerDto(customerRepository
                .save(customerMapper
                        .fromCustomerDtoToCustomerEntity(entity)));
    }

    @Override
    public CustomerDTO getById(Integer id) throws NotFoundException {
        if(!customerRepository.existsById(id)){
            throw new NotFoundException("Il customer non è presente nel DB");
        }
        return customerMapper.fromCustomerEntityToCustomerDto(customerRepository.getById(id));
    }

    @Override
    public Set<CustomerDTO> getAll() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomerEntityToCustomerDto)
                .collect(Collectors.toSet());
    }

    @Override
    public CustomerDTO update(CustomerDTO entity) throws NotFoundException {
        if(!customerRepository.existsById(entity.getId())){
            throw new NotFoundException("Il customer non è presente nel DB");
        }
        CustomerEntity customerUpdate = customerRepository.save(customerMapper.fromCustomerDtoToCustomerEntity(entity));
        return customerMapper.fromCustomerEntityToCustomerDto(customerUpdate);
    }

    @Override
    public void delete(Integer id) throws NotFoundException{
        if(!customerRepository.existsById(id)){
            throw new NotFoundException("Il customer non è presente nel DB");
        }
        customerRepository.deleteById(id);

    }

}


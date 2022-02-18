package it.unikey.esercizioconnessionelibrary.BLL.service.impl;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.CustomerDTO;
import it.unikey.esercizioconnessionelibrary.BLL.mapper.CustomerMapper;
import it.unikey.esercizioconnessionelibrary.BLL.service.CrudService;
import it.unikey.esercizioconnessionelibrary.DAL.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CrudService<CustomerDTO> {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public CustomerDTO insert(CustomerDTO entity) {
        return null;
    }

    @Override
    public CustomerDTO getById(Integer id) {
        return null;
    }

    @Override
    public Set<CustomerDTO> getAll() {
        return null;
    }

    @Override
    public CustomerDTO update(CustomerDTO entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}


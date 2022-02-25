package it.unikey.esercizioconnessionelibrary.BLL.service;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.CustomerDTO;
import it.unikey.esercizioconnessionelibrary.BLL.exception.NotFoundException;

import java.util.Set;

public interface RegistryService<T> extends CrudService<T>{

    Set<CustomerDTO> getBySurname(String surname) throws NotFoundException;

    Set<CustomerDTO> getByNameAndSurame(String name, String surname) throws NotFoundException;

    }

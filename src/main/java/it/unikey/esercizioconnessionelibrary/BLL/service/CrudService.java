package it.unikey.esercizioconnessionelibrary.BLL.service;

import it.unikey.esercizioconnessionelibrary.BLL.exception.NotFoundException;

import java.util.Set;

public interface CrudService<T> {
    T insert(T entity);
    T getById(Integer id) throws NotFoundException;
    Set<T> getAll();
    T update(T entity) throws NotFoundException;
    void delete(Integer id) throws NotFoundException;
}

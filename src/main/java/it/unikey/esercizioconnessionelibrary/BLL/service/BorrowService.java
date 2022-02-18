package it.unikey.esercizioconnessionelibrary.BLL.service;

import it.unikey.esercizioconnessionelibrary.BLL.exception.NotFoundException;
import it.unikey.esercizioconnessionelibrary.DAL.entities.BarrowPk;

import java.util.Set;

public interface BorrowService<T> {

        T insert(T entity);
        T getById(BarrowPk id) throws NotFoundException;
        Set<T> getAll();
        T update(T entity) throws NotFoundException;
        void delete(BarrowPk id) throws NotFoundException;
}

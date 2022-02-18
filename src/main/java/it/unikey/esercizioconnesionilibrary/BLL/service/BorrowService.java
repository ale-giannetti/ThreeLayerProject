package it.unikey.esercizioconnesionilibrary.BLL.service;

import it.unikey.esercizioconnesionilibrary.BLL.exception.NotFoundException;
import it.unikey.esercizioconnesionilibrary.DAL.entity.BorrowPK;

import java.util.Set;

public interface BorrowService<T> {
    T insert(T entity);
    T getById(BorrowPK borrowPK) throws NotFoundException;
    Set<T> getAll();
    T update(T entity) throws NotFoundException;
    void delete(BorrowPK borrowPK) throws NotFoundException;
}

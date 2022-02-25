package it.unikey.esercizioconnessionelibrary.BLL.service;

import it.unikey.esercizioconnessionelibrary.BLL.exception.DateNotFoundException;
import it.unikey.esercizioconnessionelibrary.BLL.exception.NotFoundException;

import java.time.LocalDate;
import java.util.Set;

public interface DateService<T> extends CrudService<T> {

    Set<T> getAllBorrowsByDate(LocalDate start_date, LocalDate end_date) throws DateNotFoundException;
    Set<T> getByEndDate(LocalDate end_date) throws DateNotFoundException;
    Set<T> getByEndDateNull();
}

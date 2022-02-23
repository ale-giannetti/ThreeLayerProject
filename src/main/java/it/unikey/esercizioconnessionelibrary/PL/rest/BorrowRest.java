package it.unikey.esercizioconnessionelibrary.PL.rest;



import it.unikey.esercizioconnessionelibrary.DAL.entities.BarrowPk;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowRest {

    private BarrowPk barrowPk;
    private BookRest book;
    private CustomerRest customer;
    private LocalDate startDate;
    private LocalDate endDate;

}

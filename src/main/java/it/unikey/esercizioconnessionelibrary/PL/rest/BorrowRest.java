package it.unikey.esercizioconnessionelibrary.PL.rest;



import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowRest {

    private Integer id;
    private BookRest book;
    private CustomerRest customer;
    private LocalDate startDate;
    private LocalDate endDate;

}

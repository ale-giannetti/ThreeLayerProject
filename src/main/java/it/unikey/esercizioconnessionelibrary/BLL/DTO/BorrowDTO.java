package it.unikey.esercizioconnessionelibrary.BLL.DTO;

import java.time.LocalDate;

public class BorrowDTO {

    private BookDTO book;
    private CustomerDTO customer;
    private LocalDate startDate;
    private LocalDate endDate;
}

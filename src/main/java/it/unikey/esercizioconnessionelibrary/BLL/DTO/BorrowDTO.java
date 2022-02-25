package it.unikey.esercizioconnessionelibrary.BLL.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowDTO {

    private Integer id;
    private BookDTO book;
    private CustomerDTO customer;
    private LocalDate startDate;
    private LocalDate endDate;

}

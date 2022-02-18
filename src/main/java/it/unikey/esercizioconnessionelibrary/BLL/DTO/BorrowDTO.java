package it.unikey.esercizioconnessionelibrary.BLL.DTO;

import it.unikey.esercizioconnessionelibrary.DAL.entities.BarrowPk;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowDTO {

    private BarrowPk barrowPk;
    private BookDTO book;
    private CustomerDTO customer;
    private LocalDate startDate;
    private LocalDate endDate;
}

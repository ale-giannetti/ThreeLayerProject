package it.unikey.esercizioconnesionilibrary.BLL.DTO;

import it.unikey.esercizioconnesionilibrary.DAL.entity.BookEntity;
import it.unikey.esercizioconnesionilibrary.DAL.entity.BorrowPK;
import it.unikey.esercizioconnesionilibrary.DAL.entity.CustomerEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private CustomerDTO customersDTO;
    private BookDTO bookDTO;
    private BorrowPK borrowPK;
}

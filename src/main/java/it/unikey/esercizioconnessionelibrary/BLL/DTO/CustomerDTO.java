package it.unikey.esercizioconnessionelibrary.BLL.DTO;

import lombok.Data;

import java.util.Set;

@Data
public class CustomerDTO {

    private Integer id;
    private String name;
    private String surname;
    private Set<BorrowDTO> borrow;

}

package it.unikey.esercizioconnessionelibrary.BLL.DTO;

import java.util.Set;

public class CustomerDTO {

    private Integer id;
    private String name;
    private String surname;
    private Set<BorrowDTO> borrow;

}

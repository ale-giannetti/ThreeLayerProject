package it.unikey.esercizioconnessionelibrary.PL.rest;


import lombok.Data;

import java.util.Set;

@Data
public class CustomerRest {

    private Integer id;
    private String name;
    private String surname;
    private Set<BorrowRest> borrow;

}

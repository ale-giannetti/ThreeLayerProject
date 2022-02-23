package it.unikey.esercizioconnessionelibrary.PL.rest;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.BookDTO;
import lombok.Data;

import java.util.Set;

@Data
public class AuthorRest {

    private Integer id;
    private String name;
    private String surname;
    private Set<BookRest> book;

}

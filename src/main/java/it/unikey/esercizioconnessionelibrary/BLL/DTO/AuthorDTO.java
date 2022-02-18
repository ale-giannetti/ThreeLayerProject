package it.unikey.esercizioconnessionelibrary.BLL.DTO;

import it.unikey.esercizioconnessionelibrary.DAL.entities.BookEntity;

import java.util.Set;

public class AuthorDTO {

    private Integer id;
    private String name;
    private String surname;
    private Set<BookDTO> book;

}

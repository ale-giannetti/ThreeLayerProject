package it.unikey.esercizioconnessionelibrary.PL.rest;


import lombok.Data;

import java.util.Set;

@Data
public class GenreRest {

    private Integer id;
    private String nameGenre;
    private Set<BookRest> book;

}

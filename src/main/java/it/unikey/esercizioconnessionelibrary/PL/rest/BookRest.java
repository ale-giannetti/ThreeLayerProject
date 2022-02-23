package it.unikey.esercizioconnessionelibrary.PL.rest;
import lombok.Data;

import java.util.Set;

@Data
public class BookRest {

    private Integer id;
    private String title;
    private AuthorRest author;
    private GenreRest genre;
    private Set<BorrowRest> borrow;
}

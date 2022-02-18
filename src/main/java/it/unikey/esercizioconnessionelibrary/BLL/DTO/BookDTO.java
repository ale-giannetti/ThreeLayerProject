package it.unikey.esercizioconnessionelibrary.BLL.DTO;

import java.util.Set;

public class BookDTO {

    private Integer id;
    private String title;
    private AuthorDTO author;
    private GenreDto genre;
    private Set<BorrowDTO> borrow;

}

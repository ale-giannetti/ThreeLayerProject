package it.unikey.esercizioconnessionelibrary.BLL.DTO;

import lombok.Data;

import java.util.Set;

@Data
public class BookDTO {

    private Integer id;
    private String title;
    private AuthorDTO author;
    private GenreDto genre;
    private Set<BorrowDTO> borrow;

}

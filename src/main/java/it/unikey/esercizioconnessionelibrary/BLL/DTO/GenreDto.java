package it.unikey.esercizioconnessionelibrary.BLL.DTO;

import lombok.Data;

import java.util.Set;

@Data

public class GenreDto {

    private Integer id;
    private String nameGenre;
    private Set<BookDTO> book;
}

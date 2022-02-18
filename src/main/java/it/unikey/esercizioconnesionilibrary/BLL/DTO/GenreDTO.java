package it.unikey.esercizioconnesionilibrary.BLL.DTO;

import it.unikey.esercizioconnesionilibrary.DAL.entity.BookEntity;
import lombok.Data;

import java.util.Set;

@Data
public class GenreDTO {
    private Integer id;
    private String name;
    private Set<BookDTO> booksDTO;
}

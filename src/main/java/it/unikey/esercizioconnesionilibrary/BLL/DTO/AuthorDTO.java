package it.unikey.esercizioconnesionilibrary.BLL.DTO;

import it.unikey.esercizioconnesionilibrary.DAL.entity.BookEntity;
import lombok.Data;

import java.util.Set;

@Data
public class AuthorDTO {
    private Integer id;
    private String name;
    private String surname;
    private Set<BookDTO> booksDTO;
}

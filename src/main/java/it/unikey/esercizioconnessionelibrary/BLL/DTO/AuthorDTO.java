package it.unikey.esercizioconnessionelibrary.BLL.DTO;

import it.unikey.esercizioconnessionelibrary.DAL.entities.BookEntity;
import lombok.Data;

import java.util.Set;

@Data
public class AuthorDTO {

    private Integer id;
    private String name;
    private String surname;
    private Set<BookDTO> book;

}

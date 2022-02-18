package it.unikey.esercizioconnesionilibrary.BLL.DTO;

import it.unikey.esercizioconnesionilibrary.DAL.entity.AuthorEntity;
import it.unikey.esercizioconnesionilibrary.DAL.entity.BookEntity;
import it.unikey.esercizioconnesionilibrary.DAL.entity.BorrowEntity;
import it.unikey.esercizioconnesionilibrary.DAL.entity.GenreEntity;
import lombok.Data;

import java.util.Set;

@Data
public class BookDTO {
    private Integer id;
    private String title;
    private GenreEntity genre;
    private AuthorEntity author;
    private Set<BorrowDTO> borrowsDTO;
}

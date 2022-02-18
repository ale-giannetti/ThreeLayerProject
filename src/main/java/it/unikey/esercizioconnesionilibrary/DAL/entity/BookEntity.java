package it.unikey.esercizioconnesionilibrary.DAL.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private AuthorEntity author;

    @ManyToOne
    private GenreEntity genre;

    @OneToMany(mappedBy = "books", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BorrowEntity> borrows;

}

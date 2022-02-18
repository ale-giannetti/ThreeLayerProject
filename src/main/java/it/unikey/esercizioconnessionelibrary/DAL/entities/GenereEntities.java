package it.unikey.esercizioconnessionelibrary.DAL.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class GenereEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nameGenre;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<BookEntity> bookGenre;
}

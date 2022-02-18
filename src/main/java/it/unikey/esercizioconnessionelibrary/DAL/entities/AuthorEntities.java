package it.unikey.esercizioconnessionelibrary.DAL.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class AuthorEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<BookEntity> book;


}

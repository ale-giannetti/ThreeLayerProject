package it.unikey.esercizioconnessionelibrary.DAL.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private AuthorEntities author;


    //creazione di una many to many con tabella di relazione
   /* @ManyToMany(mappedBy = "books" )
    private Set<CustomerEntities> customer;*/

    @ManyToOne
    private GenereEntities genre;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Set<BorrowEntity> barrowEntities;

}

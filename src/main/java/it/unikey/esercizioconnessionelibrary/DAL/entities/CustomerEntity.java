package it.unikey.esercizioconnessionelibrary.DAL.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "CUSTOMER_ENTITIES")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<BorrowEntity> barrowEntities;


/*
    Creazione di una many to many sviluppando una tabella di relazione
    @ManyToMany
    @JoinTable(
            name = "BORROW",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<BookEntities> books;
*/

}

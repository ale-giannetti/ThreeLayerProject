package it.unikey.esercizioconnessionelibrary.DAL.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
public class BorrowEntity implements Serializable {

    @EmbeddedId
    private BarrowPk barrowPk;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @MapsId("bookId")
    @JoinColumn(name = "BOOK_ID")
    private BookEntity book;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @MapsId("customerId")
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customer;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

}

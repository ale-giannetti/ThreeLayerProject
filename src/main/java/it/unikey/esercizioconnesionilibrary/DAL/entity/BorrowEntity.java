package it.unikey.esercizioconnesionilibrary.DAL.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Borrow")
public class BorrowEntity implements Serializable {

    @EmbeddedId
    private BorrowPK id;

    @ManyToOne
    @MapsId("bookId")
    //@JoinColumn(name = "BOOK_ID") //tanto l'ho messo in BorrowPK
    private BookEntity books;

    @ManyToOne
    @MapsId("customerId")
    //@JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customers;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;


}

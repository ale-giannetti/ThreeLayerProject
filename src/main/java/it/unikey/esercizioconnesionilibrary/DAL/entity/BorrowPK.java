package it.unikey.esercizioconnesionilibrary.DAL.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class BorrowPK implements Serializable {

    @Column(name = "BOOK_ID")
    private Integer bookId;

    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

}

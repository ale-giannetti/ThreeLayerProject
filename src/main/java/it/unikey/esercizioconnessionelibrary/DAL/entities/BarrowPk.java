package it.unikey.esercizioconnessionelibrary.DAL.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BarrowPk implements Serializable {

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "book_id")
    private int bookId;

}

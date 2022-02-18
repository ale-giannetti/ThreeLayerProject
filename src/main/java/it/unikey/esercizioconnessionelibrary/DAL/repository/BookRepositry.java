package it.unikey.esercizioconnessionelibrary.DAL.repository;

import it.unikey.esercizioconnessionelibrary.DAL.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepositry extends JpaRepository<BookEntity, Integer>{

    @Query("SELECT BookEntity.title, CustomerEntity.name, CustomerEntity.surname FROM BookEntity" +
            " INNER JOIN BorrowEntity ON BookEntity.id = BorrowEntity.book.id " +
            "INNER JOIN CustomerEntity ON BorrowEntity.customer.id = CustomerEntity.id")
    Set<BookEntity> bookBorrowAtCustomer(Integer id);

}

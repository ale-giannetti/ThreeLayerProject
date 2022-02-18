package it.unikey.esercizioconnesionilibrary.DAL.repository;


import it.unikey.esercizioconnesionilibrary.DAL.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {


    @Query("SELECT BookEntity.title, CustomerEntity.name, CustomerEntity.surname FROM  BookEntity " +
            "INNER JOIN BorrowEntity ON BookEntity.id = BorrowEntity.books.id  " +
            "INNER JOIN CustomerEntity ON BorrowEntity.customers.id = CustomerEntity.id ")
    Set<BookEntity> bookBorrowAtCustomer(Integer id);
}

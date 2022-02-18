package it.unikey.esercizioconnesionilibrary.DAL.repository;

import it.unikey.esercizioconnesionilibrary.DAL.entity.BookEntity;
import it.unikey.esercizioconnesionilibrary.DAL.entity.BorrowEntity;
import it.unikey.esercizioconnesionilibrary.DAL.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> { //Integer perchè voglio id

    @Query("SELECT CustomerEntity.id, CustomerEntity.name, CustomerEntity.surname, BookEntity.id, BookEntity.title, BorrowEntity.startDate, BorrowEntity.endDate FROM BookEntity " +
            "INNER JOIN BorrowEntity ON BookEntity.id = BorrowEntity.books.id " +
            "INNER JOIN CustomerEntity ON BorrowEntity.customers.id = CustomerEntity.id")
    Set<CustomerEntity> barrowBetweeenTwoDate(LocalDate start, LocalDate end);




}

package it.unikey.esercizioconnessionelibrary.DAL.repository;

import it.unikey.esercizioconnessionelibrary.DAL.entities.BarrowPk;
import it.unikey.esercizioconnessionelibrary.DAL.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{

    @Query("SELECT CustomerEntity.id, CustomerEntity.name, CustomerEntity.surname, BookEntity.id, BookEntity.title, BorrowEntity.startDate, BorrowEntity.endDate " +
            "FROM BookEntity " +
            "INNER JOIN BorrowEntity ON BookEntity.id = BorrowEntity.book.id " +
            "INNER JOIN CustomerEntity ON BorrowEntity.customer.id = CustomerEntity.id")
    Set<CustomerEntity> barrowBetweeenTwoDate(LocalDate start, LocalDate end);


}

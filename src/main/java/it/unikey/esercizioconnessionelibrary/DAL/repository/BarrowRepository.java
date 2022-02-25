package it.unikey.esercizioconnessionelibrary.DAL.repository;

import it.unikey.esercizioconnessionelibrary.DAL.entities.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface BarrowRepository extends JpaRepository<BorrowEntity, Integer> {

    Set<BorrowEntity> findBorrowEntityBetweenStartDateAndEndDate(LocalDate start_date, LocalDate end_date);
    Set<BorrowEntity> findBorrowEntityByEndDate(LocalDate end_date);
    Set<BorrowEntity> findBorrowEntityByEndDateIsNull();
}

package it.unikey.esercizioconnessionelibrary.DAL.repository;

import it.unikey.esercizioconnessionelibrary.DAL.entities.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarrowRepository extends JpaRepository<BorrowEntity, Integer> {

}

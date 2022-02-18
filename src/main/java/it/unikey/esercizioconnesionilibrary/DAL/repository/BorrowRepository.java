package it.unikey.esercizioconnesionilibrary.DAL.repository;

import it.unikey.esercizioconnesionilibrary.DAL.entity.BorrowEntity;
import it.unikey.esercizioconnesionilibrary.DAL.entity.BorrowPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<BorrowEntity, BorrowPK> {

}

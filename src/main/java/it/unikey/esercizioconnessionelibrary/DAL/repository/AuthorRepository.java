package it.unikey.esercizioconnessionelibrary.DAL.repository;

import it.unikey.esercizioconnessionelibrary.DAL.entities.AuthorEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntities, Integer> {
}

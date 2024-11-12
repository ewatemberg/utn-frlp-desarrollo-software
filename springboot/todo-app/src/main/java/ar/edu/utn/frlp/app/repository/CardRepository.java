package ar.edu.utn.frlp.app.repository;

import ar.edu.utn.frlp.app.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}

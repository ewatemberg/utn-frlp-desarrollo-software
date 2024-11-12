package ar.edu.utn.frlp.app.repository;

import ar.edu.utn.frlp.app.domain.Board;
import ar.edu.utn.frlp.app.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}

package ar.edu.utn.frlp.app.repository;

import ar.edu.utn.frlp.app.domain.ColumnBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnRepository extends JpaRepository<ColumnBoard, Long> {
}

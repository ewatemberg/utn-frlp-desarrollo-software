package ar.edu.utn.frlp.app.service;

import ar.edu.utn.frlp.app.domain.ColumnBoard;
import ar.edu.utn.frlp.app.dto.ColumnBoardDTO;
import ar.edu.utn.frlp.app.mapper.CardMapper;
import ar.edu.utn.frlp.app.mapper.ColumnBoardMapper;
import ar.edu.utn.frlp.app.repository.ColumnRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ColumnBoardService {

    private final Logger log = LoggerFactory.getLogger(ColumnBoardService.class);

    @Autowired
    ColumnRepository columnRepository;

    @Autowired
    ColumnBoardMapper columnBoardMapper;

    @Autowired
    CardMapper cardMapper;

    public ColumnBoardDTO save(ColumnBoardDTO columnBoardDTO) {
        log.debug("Request to save Column : {}", columnBoardDTO);
        ColumnBoard columnBoard = columnBoardMapper.toEntity(columnBoardDTO);
        columnBoard = columnRepository.save(columnBoard);
        return columnBoardMapper.toDto(columnBoard);
    }

    public Optional<ColumnBoardDTO> partialUpdate(ColumnBoardDTO columnBoardDTO) {
        log.debug("Request to partially update Column : {}", columnBoardDTO);
        if (!columnRepository.existsById(columnBoardDTO.getId()))
            return Optional.empty();
        ColumnBoard existingColumnBoard = columnRepository.findById(columnBoardDTO.getId()).get();
        ColumnBoard columnBoardUpdated = columnBoardMapper.toEntity(columnBoardDTO);
        existingColumnBoard.setId(columnBoardUpdated.getId());
        existingColumnBoard.setBoard(columnBoardUpdated.getBoard());
        existingColumnBoard.setCards(columnBoardUpdated.getCards());
        existingColumnBoard.setOrder(columnBoardUpdated.getOrder());
        existingColumnBoard = columnRepository.save(existingColumnBoard);
        return Optional.of((columnBoardMapper.toDto(existingColumnBoard)));
    }

    @Transactional(readOnly = true)
    public Page<ColumnBoardDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Columns");
        return columnRepository.findAll(pageable).map(columnBoardMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<ColumnBoardDTO> findOne(Long id) {
        log.debug("Request to get Column : {}", id);
        Optional<ColumnBoard> columnBoard = columnRepository.findById(id);
        return Optional.of(columnBoardMapper.toDto(columnBoard.get()));
    }

    public void delete(Long id) {
        log.debug("Request to delete Column : {}", id);
        columnRepository.deleteById(id);
    }

}

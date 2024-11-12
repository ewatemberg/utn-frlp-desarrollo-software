package ar.edu.utn.frlp.app.service;

import ar.edu.utn.frlp.app.domain.Board;
import ar.edu.utn.frlp.app.dto.BoardDTO;
import ar.edu.utn.frlp.app.mapper.BoardMapper;
import ar.edu.utn.frlp.app.repository.BoardRepository;
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
public class BoardService {

    private final Logger log = LoggerFactory.getLogger(BoardService.class);

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardMapper boardMapper;

    public BoardDTO save(BoardDTO boardDTO) {
        log.debug("Request to save Board : {}", boardDTO);
        Board board = boardMapper.toEntity(boardDTO);
        board = boardRepository.save(board);
        return boardMapper.toDto(board);
    }

    public Optional<BoardDTO> partialUpdate(BoardDTO boardDTO) {
        log.debug("Request to partially update Board : {}", boardDTO);
        if (!boardRepository.existsById(boardDTO.getId()))
            return Optional.empty();
        Board existingBoard = boardRepository.findById(boardDTO.getId()).get();
        Board boardUpdated = boardMapper.toEntity(boardDTO);
        existingBoard.setId(boardUpdated.getId());
        existingBoard.setName(boardUpdated.getName());
        existingBoard.setUser(boardUpdated.getUser());
        existingBoard = boardRepository.save(existingBoard);
        return Optional.of(boardMapper.toDto(existingBoard));
    }

    @Transactional(readOnly = true)
    public Page<BoardDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Boards");
        return boardRepository.findAll(pageable).map(boardMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<BoardDTO> findOne(Long id) {
        log.debug("Request to get Board : {}", id);
        Optional<Board> board = boardRepository.findById(id);
        return Optional.of(boardMapper.toDto(board.get()));
    }

    public void delete(Long id) {
        log.debug("Request to delete Board : {}", id);
        boardRepository.deleteById(id);
    }

}

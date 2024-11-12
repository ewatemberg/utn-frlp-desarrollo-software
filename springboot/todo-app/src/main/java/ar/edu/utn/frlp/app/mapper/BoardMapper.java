package ar.edu.utn.frlp.app.mapper;

import ar.edu.utn.frlp.app.domain.Board;
import ar.edu.utn.frlp.app.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper for the entity Board and its DTO BoardDTO.
 */
@Component
public class BoardMapper implements EntityMapper<BoardDTO, Board> {

    @Autowired
    UserMapper userMapper;

    @Override
    public Board toEntity(BoardDTO dto) {
        Board board = new Board();
        board.setId(dto.getId());
        board.setName(dto.getName());
        board.setUser(userMapper.fromId(dto.getUserId()));
        return board;
    }

    @Override
    public BoardDTO toDto(Board entity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(entity.getId());
        boardDTO.setName(entity.getName());
        if (entity.getUser() != null)
            boardDTO.setUserId(entity.getUser().getId());
        return boardDTO;
    }

    @Override
    public List<Board> toEntity(List<BoardDTO> dtoList) {
        List<Board> list = new ArrayList<Board>();
        for (BoardDTO boardDTO : dtoList) {
            list.add(toEntity(boardDTO));
        }
        return list;
    }

    @Override
    public List<BoardDTO> toDto(List<Board> entityList) {
        List<BoardDTO> list = new ArrayList<BoardDTO>();
        for (Board board : entityList) {
            list.add(toDto(board));
        }
        return list;
    }

    Board fromId(Long id) {
        if (id == null) {
            return null;
        }
        Board board = new Board();
        board.setId(id);
        return board;
    }
}

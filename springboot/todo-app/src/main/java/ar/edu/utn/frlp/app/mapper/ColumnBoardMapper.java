package ar.edu.utn.frlp.app.mapper;

import ar.edu.utn.frlp.app.domain.ColumnBoard;
import ar.edu.utn.frlp.app.dto.ColumnBoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ColumnBoardMapper implements EntityMapper<ColumnBoardDTO, ColumnBoard> {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private CardMapper cardMapper;

    @Override
    public ColumnBoard toEntity(ColumnBoardDTO dto) {
        ColumnBoard columnBoard = new ColumnBoard();
        columnBoard.setId(dto.getId());
        columnBoard.setOrder(dto.getOrder());
        columnBoard.setBoard(boardMapper.toEntity(dto.getBoard()));
        columnBoard.setCards(cardMapper.toEntity(dto.getCards()));
        columnBoard.setName(dto.getName());
        return columnBoard;
    }

    @Override
    public ColumnBoardDTO toDto(ColumnBoard entity) {
        ColumnBoardDTO columnBoardDTO = new ColumnBoardDTO();
        columnBoardDTO.setId(entity.getId());
        columnBoardDTO.setOrder(entity.getOrder());
        columnBoardDTO.setBoard(boardMapper.toDto(entity.getBoard()));
        columnBoardDTO.setCards(cardMapper.toDto(entity.getCards()));
        columnBoardDTO.setName(entity.getName());
        return columnBoardDTO;
    }

    @Override
    public List<ColumnBoard> toEntity(List<ColumnBoardDTO> dtoList) {
        List<ColumnBoard> list = new ArrayList<ColumnBoard>();
        for (ColumnBoardDTO columnBoardDTO : dtoList) {
            list.add(toEntity(columnBoardDTO));
        }
        return list;
    }

    @Override
    public List<ColumnBoardDTO> toDto(List<ColumnBoard> entityList) {
        List<ColumnBoardDTO> list = new ArrayList<ColumnBoardDTO>();
        for (ColumnBoard columnBoard : entityList) {
            list.add(toDto(columnBoard));
        }
        return list;
    }

    ColumnBoard fromId(Long id) {
        if (id == null) {
            return null;
        }
        ColumnBoard columnBoard = new ColumnBoard();
        columnBoard.setId(id);
        return columnBoard;
    }
}

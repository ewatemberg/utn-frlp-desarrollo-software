package ar.edu.utn.frlp.app.mapper;

import ar.edu.utn.frlp.app.domain.Card;
import ar.edu.utn.frlp.app.dto.CardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardMapper implements EntityMapper<CardDTO, Card> {

    @Autowired
    ColumnBoardMapper columnBoardMapper;

    @Override
    public Card toEntity(CardDTO dto) {
        Card card = new Card();
        card.setId(dto.getId());
        card.setDescription(dto.getDescription());
        card.setOrder(dto.getOrder());
        card.setTitle(dto.getTitle());
        card.setColumnBoard(columnBoardMapper.fromId(dto.getColumnBoardId()));
        return card;
    }

    @Override
    public CardDTO toDto(Card entity) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(entity.getId());
        cardDTO.setDescription(entity.getDescription());
        cardDTO.setOrder(entity.getOrder());
        cardDTO.setTitle(entity.getTitle());
        if (entity.getColumnBoard() != null)
            cardDTO.setColumnBoardId(entity.getColumnBoard().getId());
        return cardDTO;
    }

    @Override
    public List<Card> toEntity(List<CardDTO> dtoList) {
        List<Card> list = new ArrayList<Card>();
        for (CardDTO cardDTO : dtoList) {
            list.add(toEntity(cardDTO));
        }
        return list;
    }

    @Override
    public List<CardDTO> toDto(List<Card> entityList) {
        List<CardDTO> list = new ArrayList<CardDTO>();
        for (Card card : entityList) {
            list.add(toDto(card));
        }
        return list;
    }

    Card fromId(Long id) {
        if (id == null) {
            return null;
        }
        Card card = new Card();
        card.setId(id);
        return card;
    }
}

package ar.edu.utn.frlp.app.service;

import ar.edu.utn.frlp.app.domain.Card;
import ar.edu.utn.frlp.app.dto.CardDTO;
import ar.edu.utn.frlp.app.mapper.CardMapper;
import ar.edu.utn.frlp.app.repository.CardRepository;
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
public class CardService {

    private final Logger log = LoggerFactory.getLogger(CardService.class);

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardMapper cardMapper;

    public CardDTO save(CardDTO cardDTO) {
        log.debug("Request to save Card : {}", cardDTO);
        Card card = cardMapper.toEntity(cardDTO);
        card = cardRepository.save(card);
        return cardMapper.toDto(card);
    }

    public Optional<CardDTO> partialUpdate(CardDTO cardDTO) {
        log.debug("Request to partially update Card : {}", cardDTO);
        if (!cardRepository.existsById(cardDTO.getId()))
            return Optional.empty();
        Card existingCard = cardRepository.findById(cardDTO.getId()).get();
        Card cardUpdated = cardMapper.toEntity(cardDTO);
        existingCard.setId(cardUpdated.getId());
        existingCard.setDescription(cardUpdated.getDescription());
        existingCard.setOrder(cardUpdated.getOrder());
        existingCard.setColumnBoard(cardUpdated.getColumnBoard());
        existingCard = cardRepository.save(existingCard);
        return Optional.of(cardMapper.toDto(existingCard));
    }

    @Transactional(readOnly = true)
    public Page<CardDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Cards");
        return cardRepository.findAll(pageable).map(cardMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<CardDTO> findOne(Long id) {
        log.debug("Request to get Card : {}", id);
        Optional<Card> card = cardRepository.findById(id);
        return Optional.of(cardMapper.toDto(card.get()));
    }

    public void delete(Long id) {
        log.debug("Request to delete Card : {}", id);
        cardRepository.deleteById(id);
    }

}

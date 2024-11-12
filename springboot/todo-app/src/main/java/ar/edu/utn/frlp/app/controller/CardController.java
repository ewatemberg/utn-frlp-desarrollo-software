package ar.edu.utn.frlp.app.controller;

import ar.edu.utn.frlp.app.config.ApiVersion;
import ar.edu.utn.frlp.app.controller.util.PaginationUtil;
import ar.edu.utn.frlp.app.controller.util.ResponseUtil;
import ar.edu.utn.frlp.app.dto.CardDTO;
import ar.edu.utn.frlp.app.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class CardController {

    private final Logger log = LoggerFactory.getLogger(CardController.class);

    @Autowired
    private CardService cardService;

    @Operation(summary = "Crea una nueva tarjeta")
    @PostMapping("/api/" + ApiVersion.V1 + "/cards")
    public ResponseEntity<CardDTO> createCard(@RequestBody CardDTO card) throws URISyntaxException {
        log.debug("REST request to save Card : {}", card);
        CardDTO result = cardService.save(card);
        return ResponseEntity
                .created(new URI("/api/cards/" + result.getId()))
                .body(result);
    }

    @Operation(summary = "Actualiza una tarjeta de forma completa")
    @PutMapping("/api/" + ApiVersion.V1 + "/cards/{id}")
    public ResponseEntity<CardDTO> updateCard(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody CardDTO card) {
        log.debug("REST request to update Card : {}, {}", id, card);
        CardDTO result = cardService.save(card);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @Operation(summary = "Actualiza una tarjeta de forma parcial")
    @PatchMapping(value = "/api/" + ApiVersion.V1 + "/cards/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<CardDTO> partialUpdateCard(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody CardDTO card) {
        log.debug("REST request to partial update Card partially : {}, {}", id, card);
        Optional<CardDTO> result = cardService.partialUpdate(card);
        return ResponseUtil.wrapOrNotFound(result, null);
    }

    @Operation(summary = "Obtiene todas las tarjetas paginadas")
    @GetMapping("/api/" + ApiVersion.V1 + "/cards")
    public ResponseEntity<List<CardDTO>> getAllCards(Pageable pageable) {
        log.debug("REST request to get a page of Card");
        Page<CardDTO> page = cardService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @Operation(summary = "Obtiene una tarjeta por id")
    @GetMapping("/api/" + ApiVersion.V1 + "/cards/{id}")
    public ResponseEntity<CardDTO> getCard(@PathVariable Long id) {
        log.debug("REST request to get Card : {}", id);
        Optional<CardDTO> card = cardService.findOne(id);
        return ResponseUtil.wrapOrNotFound(card);
    }

    @Operation(summary = "Elimina una tarjeta por id")
    @DeleteMapping("/api/" + ApiVersion.V1 + "/cards/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        log.debug("REST request to delete Card : {}", id);
        cardService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

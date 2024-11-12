package ar.edu.utn.frlp.app.controller;

import ar.edu.utn.frlp.app.config.ApiVersion;
import ar.edu.utn.frlp.app.controller.util.PaginationUtil;
import ar.edu.utn.frlp.app.controller.util.ResponseUtil;
import ar.edu.utn.frlp.app.domain.Board;
import ar.edu.utn.frlp.app.dto.BoardDTO;
import ar.edu.utn.frlp.app.service.BoardService;
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
public class BoardController {

    private final Logger log = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @Operation(summary = "Crea un nuevo tablero")
    @PostMapping("/api/" + ApiVersion.V1 + "/boards")
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO board) throws URISyntaxException {
        log.debug("REST request to save Board : {}", board);
        BoardDTO result = boardService.save(board);
        return ResponseEntity
                .created(new URI("/api/board/" + result.getId()))
                .body(result);
    }

    @Operation(summary = "Actualiza un tablero de forma completa")
    @PutMapping("/api/" + ApiVersion.V1 + "/boards/{id}")
    public ResponseEntity<BoardDTO> updateBoard(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody BoardDTO board) {
        log.debug("REST request to update Board : {}, {}", id, board);
        BoardDTO result = boardService.save(board);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @Operation(summary = "Actualiza un tablero de forma parcial")
    @PatchMapping(value = "/api/" + ApiVersion.V1 + "/boards/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<BoardDTO> partialUpdateBoard(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody BoardDTO board) {
        log.debug("REST request to partial update Board partially : {}, {}", id, board);
        Optional<BoardDTO> result = boardService.partialUpdate(board);
        return ResponseUtil.wrapOrNotFound(result, null);
    }

    @Operation(summary = "Obtiene todo los tableros paginados")
    @GetMapping("/api/" + ApiVersion.V1 + "/boards")
    public ResponseEntity<List<BoardDTO>> getAllBoards(Pageable pageable) {
        log.debug("REST request to get a page of Board");
        Page<BoardDTO> page = boardService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @Operation(summary = "Obtiene un tablero por id")
    @GetMapping("/api/" + ApiVersion.V1 + "/boards/{id}")
    public ResponseEntity<BoardDTO> getBoard(@PathVariable Long id) {
        log.debug("REST request to get Board : {}", id);
        Optional<BoardDTO> board = boardService.findOne(id);
        return ResponseUtil.wrapOrNotFound(board);
    }

    @Operation(summary = "Elimina un tablero por id")
    @DeleteMapping("/api/" + ApiVersion.V1 + "/boards/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        log.debug("REST request to delete Board : {}", id);
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

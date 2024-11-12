package ar.edu.utn.frlp.app.controller;

import ar.edu.utn.frlp.app.config.ApiVersion;
import ar.edu.utn.frlp.app.controller.util.PaginationUtil;
import ar.edu.utn.frlp.app.controller.util.ResponseUtil;
import ar.edu.utn.frlp.app.dto.ColumnBoardDTO;
import ar.edu.utn.frlp.app.service.ColumnBoardService;
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
public class ColumnBoardController {

    private final Logger log = LoggerFactory.getLogger(ColumnBoardController.class);

    @Autowired
    private ColumnBoardService columnBoardService;

    @Operation(summary = "Crea una nueva columna")
    @PostMapping("/api/" + ApiVersion.V1 + "/columns")
    public ResponseEntity<ColumnBoardDTO> createColumn(@RequestBody ColumnBoardDTO columnBoard) throws URISyntaxException {
        log.debug("REST request to save Column : {}", columnBoard);
        ColumnBoardDTO result = columnBoardService.save(columnBoard);
        return ResponseEntity
                .created(new URI("/api/columns/" + result.getId()))
                .body(result);
    }

    @Operation(summary = "Actualiza una columna de forma completa")
    @PutMapping("/api/" + ApiVersion.V1 + "/columns/{id}")
    public ResponseEntity<ColumnBoardDTO> updateColumn(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody ColumnBoardDTO columnBoard) {
        log.debug("REST request to update Column : {}, {}", id, columnBoard);
        ColumnBoardDTO result = columnBoardService.save(columnBoard);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @Operation(summary = "Actualiza una columna de forma parcial")
    @PatchMapping(value = "/api/" + ApiVersion.V1 + "/columns/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<ColumnBoardDTO> partialUpdateColumn(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody ColumnBoardDTO columnBoard) {
        log.debug("REST request to partial update Column partially : {}, {}", id, columnBoard);
        Optional<ColumnBoardDTO> result = columnBoardService.partialUpdate(columnBoard);
        return ResponseUtil.wrapOrNotFound(result, null);
    }

    @Operation(summary = "Obtiene todo las columnas paginadas")
    @GetMapping("/api/" + ApiVersion.V1 + "/columns")
    public ResponseEntity<List<ColumnBoardDTO>> getAllColumns(Pageable pageable) {
        log.debug("REST request to get a page of Column");
        Page<ColumnBoardDTO> page = columnBoardService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @Operation(summary = "Obtiene una columna por id")
    @GetMapping("/api/" + ApiVersion.V1 + "/columns/{id}")
    public ResponseEntity<ColumnBoardDTO> getColumn(@PathVariable Long id) {
        log.debug("REST request to get Column : {}", id);
        Optional<ColumnBoardDTO> column = columnBoardService.findOne(id);
        return ResponseUtil.wrapOrNotFound(column);
    }

    @Operation(summary = "Elimina una columna por id")
    @DeleteMapping("/api/" + ApiVersion.V1 + "/columns/{id}")
    public ResponseEntity<Void> deleteColumn(@PathVariable Long id) {
        log.debug("REST request to delete Column : {}", id);
        columnBoardService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

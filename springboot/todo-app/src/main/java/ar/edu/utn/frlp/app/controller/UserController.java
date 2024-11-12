package ar.edu.utn.frlp.app.controller;

import ar.edu.utn.frlp.app.config.ApiVersion;
import ar.edu.utn.frlp.app.controller.util.PaginationUtil;
import ar.edu.utn.frlp.app.controller.util.ResponseUtil;
import ar.edu.utn.frlp.app.domain.User;
import ar.edu.utn.frlp.app.dto.UserDTO;
import ar.edu.utn.frlp.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.print.Book;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Operation(summary = "Crea un nuevo usuario")
    @PostMapping("/api/" + ApiVersion.V1 + "/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) throws URISyntaxException {
        log.debug("REST request to save User : {}", user);
        UserDTO result = userService.save(user);
        return ResponseEntity
                .created(new URI("/api/users/" + result.getId()))
                .body(result);
    }

    @Operation(summary = "Actualiza un usuario de forma completa")
    @PutMapping("/api/" + ApiVersion.V1 + "/users/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody UserDTO user) {
        log.debug("REST request to update User : {}, {}", id, user);
        UserDTO result = userService.save(user);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @Operation(summary = "Actualiza un usuario de forma parcial")
    @PatchMapping(value = "/api/" + ApiVersion.V1 + "/users/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<UserDTO> partialUpdateUser(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody UserDTO user) {
        log.debug("REST request to partial update User partially : {}, {}", id, user);
        Optional<UserDTO> result = userService.partialUpdate(user);
        return ResponseUtil.wrapOrNotFound(result, null);
    }

    @Operation(summary = "Obtiene todo los usuarios paginados")
    @GetMapping("/api/" + ApiVersion.V1 + "/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(Pageable pageable) {
        log.debug("REST request to get a page of User");
        Page<UserDTO> page = userService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @Operation(summary = "Obtiene un usuario por id")
    @GetMapping("/api/" + ApiVersion.V1 + "/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        log.debug("REST request to get User : {}", id);
        Optional<UserDTO> user = userService.findOne(id);
        return ResponseUtil.wrapOrNotFound(user);
    }

    @Operation(summary = "Elimina un usuario por id")
    @DeleteMapping("/api/" + ApiVersion.V1 + "/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.debug("REST request to delete User : {}", id);
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

package ar.edu.utn.frlp.app.service;

import ar.edu.utn.frlp.app.domain.User;
import ar.edu.utn.frlp.app.dto.UserDTO;
import ar.edu.utn.frlp.app.mapper.UserMapper;
import ar.edu.utn.frlp.app.repository.UserRepository;
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
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public UserDTO save(UserDTO userDTO) {
        log.debug("Request to save User : {}", userDTO);
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public Optional<UserDTO> partialUpdate(UserDTO userDTO) {
        log.debug("Request to partially update User : {}", userDTO);
        if (!userRepository.existsById(userDTO.getId()))
            return Optional.empty();
        User existingUser = userRepository.findById(userDTO.getId()).get();
        User userUpdated = userMapper.toEntity(userDTO);
        existingUser.setId(userUpdated.getId());
        existingUser.setUsername(userUpdated.getUsername());
        existingUser.setFirstname(userUpdated.getFirstname());
        existingUser.setLastname(userUpdated.getLastname());
        existingUser.setBoards(userUpdated.getBoards());
        existingUser = userRepository.save(existingUser);
        return Optional.of(userMapper.toDto(existingUser));
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Users");
        return userRepository.findAll(pageable).map(userMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<UserDTO> findOne(Long id) {
        log.debug("Request to get User : {}", id);
        Optional<User> user = userRepository.findById(id);
        return Optional.of(userMapper.toDto(user.get()));
    }

    public void delete(Long id) {
        log.debug("Request to delete User : {}", id);
        userRepository.deleteById(id);
    }

}

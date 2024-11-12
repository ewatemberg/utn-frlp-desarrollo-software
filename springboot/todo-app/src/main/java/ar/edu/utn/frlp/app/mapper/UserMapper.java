package ar.edu.utn.frlp.app.mapper;

import ar.edu.utn.frlp.app.domain.User;
import ar.edu.utn.frlp.app.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements EntityMapper<UserDTO, User> {

    @Override
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        return user;
    }

    @Override
    public UserDTO toDto(User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId());
        userDTO.setUsername(entity.getUsername());
        userDTO.setFirstname(entity.getFirstname());
        userDTO.setLastname(entity.getLastname());
        return userDTO;
    }

    @Override
    public List<User> toEntity(List<UserDTO> dtoList) {
        List<User> list = new ArrayList<User>();
        for (UserDTO userDTO : dtoList) {
            list.add(toEntity(userDTO));
        }
        return list;
    }

    @Override
    public List<UserDTO> toDto(List<User> entityList) {
        List<UserDTO> list = new ArrayList<UserDTO>();
        for (User user : entityList) {
            list.add(toDto(user));
        }
        return list;
    }

    User fromId(Long id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }
}

package com.hakkinenT.dspost.services;

import com.hakkinenT.dspost.models.dto.UserDTO;
import com.hakkinenT.dspost.models.entities.User;
import com.hakkinenT.dspost.repositories.UserRepository;
import com.hakkinenT.dspost.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public UserDTO findById(String id){
        User user = getEntityById(id);
        return new UserDTO(user);
    }

    private User getEntityById(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado!"));
    }

    public UserDTO insert(UserDTO dto){
        User user = new User();
        copyDTOToEntity(dto, user);

        user = userRepository.insert(user);

        return new UserDTO(user);
    }

    private void copyDTOToEntity(UserDTO dto, User user){
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
    }

    public UserDTO update(String id, UserDTO dto){
        User user = getEntityById(id);
        copyDTOToEntity(dto, user);

        user = userRepository.save(user);

        return new UserDTO(user);
    }

    public void delete(String id){
        getEntityById(id);
        userRepository.deleteById(id);
    }
}

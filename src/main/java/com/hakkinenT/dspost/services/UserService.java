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
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado!"));
        return new UserDTO(user);
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
}

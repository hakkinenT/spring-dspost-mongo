package com.hakkinenT.dspost.services;

import com.hakkinenT.dspost.models.dto.UserDTO;
import com.hakkinenT.dspost.models.entities.User;
import com.hakkinenT.dspost.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }
}

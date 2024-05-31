package com.hakkinenT.dspost.services;

import com.hakkinenT.dspost.models.dto.PostDTO;
import com.hakkinenT.dspost.models.entities.Post;
import com.hakkinenT.dspost.models.entities.User;
import com.hakkinenT.dspost.repositories.PostRepository;
import com.hakkinenT.dspost.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public PostDTO findById(String id){
        Post post = getEntityById(id);
        return new PostDTO(post);
    }

    private Post getEntityById(String id){
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado!"));
    }
}

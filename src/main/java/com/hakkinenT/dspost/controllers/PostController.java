package com.hakkinenT.dspost.controllers;

import com.hakkinenT.dspost.models.dto.PostDTO;
import com.hakkinenT.dspost.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        PostDTO post = postService.findById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<PostDTO>> findByTitle(
            @RequestParam(value = "text", defaultValue = "") String text){

        List<PostDTO> posts = postService.findByTitle(text);
        return ResponseEntity.ok(posts);
    }
}

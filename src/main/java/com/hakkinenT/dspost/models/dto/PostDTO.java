package com.hakkinenT.dspost.models.dto;

import com.hakkinenT.dspost.models.embedded.Author;
import com.hakkinenT.dspost.models.embedded.Comment;
import com.hakkinenT.dspost.models.entities.Post;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PostDTO {
    private String id;
    private Instant moment;
    private String title;
    private String body;

    private Author author;

    private List<Comment> comments = new ArrayList<>();

    public PostDTO() {
    }

    public PostDTO(String id, Instant moment, String title, String body, Author author) {
        this.id = id;
        this.moment = moment;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public PostDTO(Post post) {
        id = post.getId();
        moment = post.getMoment();
        title = post.getTitle();
        body = post.getBody();
        author = post.getAuthor();
        comments.addAll(post.getComments());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

}

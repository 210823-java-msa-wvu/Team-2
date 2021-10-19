package com.revature.foodinstagram.controllers;

import com.revature.foodinstagram.beans.Comment;
import com.revature.foodinstagram.beans.User;
import com.revature.foodinstagram.repositories.CommentRepo;
import com.revature.foodinstagram.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {

    private CommentRepo commentRepo;

    @Autowired
    public CommentController(CommentRepo commentRepo){
        this.commentRepo = commentRepo;
    }

    @GetMapping
    public List<Comment> getAllComments(){
        return commentRepo.findAll();
    }

    @GetMapping(path="/{id}")
    public Comment getById(@PathVariable("id") int id){
        return commentRepo.getById(id);
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public Comment addComment(@RequestBody Comment comment) {
        return commentRepo.save(comment);
    }

    @PutMapping(path="/{id}")
    public void updateComment(@PathVariable("id") int id, @RequestBody Comment comment) {
        if (id == comment.getId()) {
            commentRepo.save(comment);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteComment(@PathVariable("id") int id) {
        commentRepo.delete(commentRepo.getById(id));
    }
}

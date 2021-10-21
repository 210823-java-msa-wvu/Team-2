package com.revature.foodinstagram.controllers;

import com.revature.foodinstagram.beans.Comment;
import com.revature.foodinstagram.beans.User;
import com.revature.foodinstagram.repositories.CommentRepo;
import com.revature.foodinstagram.repositories.UserRepo;
import com.revature.foodinstagram.services.CommentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {

    private final CommentServices commentServices;

    @Autowired
    public CommentController(CommentServices commentServices){
        this.commentServices = commentServices;
    }

    @GetMapping("/all")
    public List<Comment> getAllComments(){
        return commentServices.getAllComments();
    }

    @GetMapping(path="/{id}")
    public Comment getById(@PathVariable("id") int id){
        return commentServices.getCommentById(id);
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public Comment addComment(@RequestBody Comment comment) {
        return commentServices.addComment(comment);
    }

    @PutMapping(path="/{id}")
    public void updateComment(@PathVariable("id") int id, @RequestBody Comment comment) {
        if (id == comment.getId()) {
            commentServices.updateComment(comment);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteComment(@PathVariable("id") int id) {
        commentServices.deleteComment(id);
    }
}

package com.revature.foodinstagram.controllers;

import com.revature.foodinstagram.beans.Comment;
import com.revature.foodinstagram.beans.Post;
import com.revature.foodinstagram.repositories.CommentRepo;
import com.revature.foodinstagram.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private PostRepo postRepo;

    @Autowired
    public PostController(PostRepo postRepo){
        this.postRepo = postRepo;
    }

    @GetMapping
    public List<Post> getAllComments(){
        return postRepo.findAll();
    }

    @GetMapping(path="/{id}")
    public Post getById(@PathVariable("id") int id){
        return postRepo.getById(id);
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public Post addPost(@RequestBody Post post) {
        return postRepo.save(post);
    }

    @PutMapping(path="/{id}")
    public void updatePost(@PathVariable("id") int id, @RequestBody Post post) {
        if (id == post.getId()) {
            postRepo.save(post);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
        }
    }

    @DeleteMapping(path="/{id}")
    public void deletePost(@PathVariable("id") int id) {
        postRepo.delete(postRepo.getById(id));
    }
}

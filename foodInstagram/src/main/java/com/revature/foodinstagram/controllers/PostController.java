package com.revature.foodinstagram.controllers;

import com.revature.foodinstagram.beans.Comment;
import com.revature.foodinstagram.beans.Post;
import com.revature.foodinstagram.repositories.CommentRepo;
import com.revature.foodinstagram.repositories.PostRepo;
import com.revature.foodinstagram.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private PostServices postServices;

    @Autowired
    public PostController(PostServices postServices) {
        this.postServices = postServices;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postServices.getPost();
    }

    @GetMapping(path = "/{id}")
    public Post getById(@PathVariable("id") int id) {
        return postServices.getById(id);
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addPost(@RequestBody Post post) {
        postServices.addPost(post);
    }
}

//    @PutMapping(path="/{id}")
//    public void updatePost(@PathVariable("id") int id, @RequestBody Post post) {
//        if (id == post.getId()) {
//            postRepo.save(post);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
//        }
//    }

//    @DeleteMapping(path="/{id}")
//    public void deletePost(@PathVariable("id") int id) {
//        postRepo.delete(postRepo.(id));
//    }
//}

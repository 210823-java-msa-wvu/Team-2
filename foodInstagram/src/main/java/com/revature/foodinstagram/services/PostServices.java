package com.revature.foodinstagram.services;

import com.revature.foodinstagram.beans.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.foodinstagram.repositories.PostRepo;


@Service
public class PostServices {

    private final PostRepo postRepo;

    @Autowired
    public PostServices(PostRepo postRepo) {
        this.postRepo = postRepo;
    }
    
        public void addPost(Post post) {
            postRepo.save(post);
        }

}


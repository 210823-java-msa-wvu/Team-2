package com.revature.foodinstagram.services;

import com.revature.foodinstagram.beans.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.foodinstagram.repositories.PostRepo;

import java.util.List;
import java.util.Optional;


@Service
public class PostServices {

    private final PostRepo postRepo;

    @Autowired
    public PostServices(PostRepo postRepo) {
        this.postRepo = postRepo;
    }
    
        public Post addPost(Post post) {
            if(post != null){
                Post p  = postRepo.save(post);
                return p;
            }
            return null;
        }

        public List<Post> getAllPosts() {
        return postRepo.findAll();
        }

        public Post getPostById(Integer id){
           Optional<Post> p = postRepo.findById(id);
          return p.orElse(null);
        }

        public void updatePost(Post post){
            if(post != null){
                postRepo.save(post);
            }
        }

        public void deletePost(Integer id){
            postRepo.delete(postRepo.getById(id));
        }


}



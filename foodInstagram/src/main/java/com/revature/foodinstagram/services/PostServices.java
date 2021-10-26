package com.revature.foodinstagram.services;

import com.revature.foodinstagram.beans.Comment;
import com.revature.foodinstagram.beans.Post;
import com.revature.foodinstagram.repositories.CommentRepo;
import org.hibernate.annotations.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.foodinstagram.repositories.PostRepo;

import java.util.List;
import java.util.Optional;


@Service
public class PostServices {

    private final PostRepo postRepo;
    private final CommentRepo commentRepo;

    @Autowired
    public PostServices(PostRepo postRepo, CommentRepo commentRepo) {
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }

    public Post addPost(Post post) {
        if(post != null){
            Post p  = postRepo.save(post);
            return p;
        }
        return null;
    }
    public List<Post> getAllPosts() {

        List<Post> post = postRepo.findByOrderByIdAsc();
        System.out.println(post);
        List<Comment> comments = commentRepo.findAll();
        System.out.println(comments);
        int length = post.size();
        int cLength = comments.size();
        for(int i = 0; i < length; i++){
            Post p = post.get(i);
            for(int j = 0; j < cLength; j++){
                Comment c = comments.get(j);
                if( p.getId() == c.getPostId()){
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
>>>>>>> main
=======
>>>>>>> main
=======
>>>>>>> main
                    p.setComment(comments);
=======
>>>>>>> 473349f0cbd285c803b61ddf328398759f2a83dc
                    List<Comment> com = p.getComment();
                    com.add(c);
                    p.setComment(com);
<<<<<<< HEAD
<<<<<<< HEAD
=======

=======
                    List<Comment> com = p.getComment();
                    com.add(c);
                    p.setComment(com);
>>>>>>> Stashed changes
>>>>>>> main
=======
>>>>>>> main
                }
            }
        }

        return post;

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

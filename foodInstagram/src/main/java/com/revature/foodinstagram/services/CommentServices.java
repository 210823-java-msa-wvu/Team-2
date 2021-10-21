package com.revature.foodinstagram.services;

import com.revature.foodinstagram.beans.Post;
import com.revature.foodinstagram.repositories.CommentRepo;
import com.revature.foodinstagram.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServices {

    private final CommentRepo commentRepo;

    @Autowired
    public CommentServices(CommentRepo commentRepo){
        this.commentRepo = commentRepo;
    }






}

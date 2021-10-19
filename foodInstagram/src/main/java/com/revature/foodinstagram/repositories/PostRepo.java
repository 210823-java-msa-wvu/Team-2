package com.revature.foodinstagram.repositories;

import com.revature.foodinstagram.beans.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
}

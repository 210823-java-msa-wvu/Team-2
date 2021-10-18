package com.revature.repository;

import com.revature.beans.Posts;

import java.util.List;

public interface PostsRepo extends CrudRepo<Posts> {

    Posts add(Posts posts);

    Posts getById(Integer id);


    List<Posts> getAll();

    void update(Posts posts);

    void delete(int id);

}

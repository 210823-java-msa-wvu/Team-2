package com.revature.repository;

import com.revature.beans.User;

import java.util.List;

public interface UserRepo extends CrudRepo<User> {

    User add(User user);

    User getById(Integer id);

    User getByUsername(String username);

    List<User> getAll();

    void update(User user);

    void delete(int id);

}

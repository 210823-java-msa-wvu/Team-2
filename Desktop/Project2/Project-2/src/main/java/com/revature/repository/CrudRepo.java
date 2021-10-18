package com.revature.repository;

import java.util.List;

public interface CrudRepo<T> {
    T add(T t);

    // Read
    T getById(Integer id);

    List<T> getAll();

    // Update
    void update(T t);

    // Delete
    void delete(int id);
}


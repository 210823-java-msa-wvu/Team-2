package com.revature.repository;


import com.revature.beans.Comments;

import java.util.List;

public interface CommentsRepo extends CrudRepo<Comments>{

    Comments add(Comments comments);

    Comments getById(Integer id);

    List<Comments> getAll();

    void update(Comments comments);

    void delete(int id);

}

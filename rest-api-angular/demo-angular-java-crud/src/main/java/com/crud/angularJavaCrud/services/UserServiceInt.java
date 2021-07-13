package com.crud.angularJavaCrud.services;

import com.crud.angularJavaCrud.entities.User;
import java.util.List;
import java.util.Optional;


public interface UserServiceInt  {

    public User save(User user);
    public void delete(User user);
    public List<User> getAll();
    public Optional<User> findById(Long id);


}
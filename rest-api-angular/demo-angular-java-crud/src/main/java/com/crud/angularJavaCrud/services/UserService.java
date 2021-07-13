package com.crud.angularJavaCrud.services;
import com.crud.angularJavaCrud.entities.User;
import com.crud.angularJavaCrud.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInt{
    
    @Autowired
    private UserRepository userRepository;


    @Override
    public User save(User user) {
        // TODO
       return  this.userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        // TODO
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
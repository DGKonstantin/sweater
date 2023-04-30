package com.example.sweeterfull.repos;

import com.example.sweeterfull.domen.Message;
import com.example.sweeterfull.domen.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}

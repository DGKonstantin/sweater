package com.example.sweterfull.repositories;

import com.example.sweterfull.domen.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long>  {
    User findByUsername(String username);
}

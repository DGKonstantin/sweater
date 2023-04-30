package com.example.sweeterfull.repos;

import com.example.sweeterfull.domen.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Integer> {
}

package com.example.wavedemo.repositories;

import com.example.wavedemo.domain.User;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}

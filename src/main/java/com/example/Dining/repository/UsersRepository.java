package com.example.Dining.repository;

import com.example.Dining.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, String> {



    Users findByName(String name);

    boolean existsByName(String name);


}
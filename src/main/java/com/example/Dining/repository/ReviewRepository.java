package com.example.Dining.repository;

import com.example.Dining.Review;
import com.example.Dining.Status;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    @Query("select r from Review r where r.status = ?1")
    Review findByStatus(Status status);

    @Transactional
    @Modifying
    @Query("update Review r set r.status = Approved where r.id = ?1")
    int updateStatusById(Integer id);

    @Transactional
    @Modifying
    @Query("update Review r set r.status = Denied where r.id = ?1")
    int Denied(Integer id);


}
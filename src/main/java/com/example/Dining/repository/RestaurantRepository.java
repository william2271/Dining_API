package com.example.Dining.repository;

import com.example.Dining.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
    @Query("select (count(r) > 0) from Restaurant r where r.nameRestaurant = ?1")
    boolean existsByNameRestaurant(String nameRestaurant);


    @Override
    Optional<Restaurant> findById(Integer integer);


}
package com.example.Dining.repository;

import com.example.Dining.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
}
package com.example.Dining.controller;
import java.lang.Iterable;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Dining.repository.*;
import com.example.Dining.Restaurant;
import com.example.Dining.Review;
import com.example.Dining.Users;
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {


    private final RestaurantRepository restaurantRepository;
private final ReviewRepository reviewRepository;
private final UsersRepository usersRepository;

    public RestaurantController(RestaurantRepository restaurantRepository, ReviewRepository reviewRepository, UsersRepository usersRepository) {
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
        this.usersRepository = usersRepository;
    }


    @GetMapping("/")
    public Iterable<Restaurant> getAllrestaurants() {
        return this.restaurantRepository.findAll();
    }

@GetMapping("/restaurants/findRestaurant")
public Users allUsers(@RequestParam(name ="name") String name){
return this.usersRepository.findByName(name);
}
    @GetMapping("/restaurants/user/{name}")
    public Users getUser(@PathVariable String name){
        return usersRepository.findByName(name);
    }
    @GetMapping("/restaurants/user/{id}")
    public Optional<Review> getReview(@PathVariable Integer id){
        return reviewRepository.findById(id);
    }

    @PostMapping("/restaurants/createRestaurant")
    public Restaurant postRestaurant (@RequestBody Restaurant object){
        return restaurantRepository.save(object);
    }
    @PostMapping("/restaurants/createUser")
    public Users postUsers (@RequestBody Users object){
        return usersRepository.save(object);
    }
    @PostMapping("/restaurants/createReview")
    public Review postReview (@RequestBody Review object){
        return reviewRepository.save(object);
    }
}

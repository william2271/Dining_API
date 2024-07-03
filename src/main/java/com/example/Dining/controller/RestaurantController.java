package com.example.Dining.controller;
import java.lang.Iterable;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
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
        return this.usersRepository.findByName(name);
    }
    @GetMapping("/restaurants/user/{id}")
    public Optional<Review> getReview(@PathVariable Integer id){
        return this.reviewRepository.findById(id);
    }

    @PostMapping("/restaurants/createRestaurant")
    public Restaurant postRestaurant (@RequestBody Restaurant object){
        Restaurant newRestaurant =this.restaurantRepository.save(object);
        return newRestaurant;
    }
    @PostMapping("/restaurants/createUser")
    public Users postUsers (@RequestBody Users object){
        Users newUsers = this.usersRepository.save(object);
        return newUsers;
    }
    @PostMapping("/restaurants/createReview")
    public Review postReview (@RequestBody Review object){
        Review newReview = this.reviewRepository.save(object);
        return newReview;
    }
    @PutMapping("/restaurants/{id}")
    public Restaurant updateRestaurant (@PathVariable("id") Integer id,
                                        @RequestBody Restaurant r){
        Optional<Restaurant> restaurantToUpdateOptional = this.restaurantRepository.findById(id);
        if (!restaurantToUpdateOptional.isPresent()) {
            return null;
        }
        Restaurant restaurantToUpdate = restaurantToUpdateOptional.get();
        if (r.getNameRestaurant() != null) {
            restaurantToUpdate.setNameRestaurant(r.getNameRestaurant());
        }
        if (r.getReview() != null) {
            restaurantToUpdate.setReview(r.getReview());
        }
        if (r.getReviewDairy() != null) {
            restaurantToUpdate.setReviewDairy(r.getReviewDairy());
        }
        if (r.getReviewEgg() != null) {
            restaurantToUpdate.setReviewEgg(r.getReviewEgg());
        }
        if (r.getReviewPeanut() != null) {
            restaurantToUpdate.setReviewPeanut(r.getReviewPeanut());
        }
        Restaurant updatedRestaurant = this.restaurantRepository.save(restaurantToUpdate);
        return updatedRestaurant;

    }
    @PutMapping("/restaurants/user/{id}")
    public Users updateuser (@PathVariable("id") Integer id,
                                        @RequestBody Users u){
        Optional<Users> usersToUpdateOptional = this.usersRepository.findById(String.valueOf(id));
        if (!usersToUpdateOptional.isPresent()) {
            return null;
        }
        Users userToUpdate = usersToUpdateOptional.get();
        if (u.getName() != null) {
            userToUpdate.setName(u.getName());
        }
        if (u.getCity() != null) {
            userToUpdate.setCity(u.getCity());
        }
        if (u.getDairyAllergies() != null) {
            userToUpdate.setDairyAllergies(u.getDairyAllergies());
        }
        if (u.getEggAllergies() != null) {
            userToUpdate.setEggAllergies(u.getEggAllergies());
        }
        if (u.getPeanutAllergies() != null) {
            userToUpdate.setPeanutAllergies(u.getPeanutAllergies());
        }
        if (u.getState() != null) {
            userToUpdate.setState(u.getState());
        }
        if (u.getZipCode() != null) {
            userToUpdate.setZipCode(u.getZipCode());
        }
        Users updatedUsers = this.usersRepository.save(userToUpdate);
        return updatedUsers;

    }
    @PutMapping("/restaurants/review/{id}")
    public Review updatereview (@PathVariable("id") Integer id,
                             @RequestBody Review re){
        Optional<Review> reviewToUpdateOptional = this.reviewRepository.findById(id);
        if (!reviewToUpdateOptional.isPresent()) {
            return null;
        }
        Review reviewToUpdate = reviewToUpdateOptional.get();
        if (re.getName() != null) {
            reviewToUpdate.setName(re.getName());
        }
        if (re.getReviewDairy() != null) {
            reviewToUpdate.setReviewDairy(re.getReviewDairy());
        }
        if (re.getReviewPeanut() != null) {
            reviewToUpdate.setReviewPeanut(re.getReviewPeanut());
        }
        if (re.getReviewEgg() != null) {
            reviewToUpdate.setReviewEgg(re.getReviewEgg());
        }
        if (re.getStatus() != null) {
            reviewToUpdate.setStatus(re.getStatus());
        }

        Review updatedReview = this.reviewRepository.save(reviewToUpdate);
        return updatedReview;

    }
    @DeleteMapping("/restaurant/delete/{id}")
    public Restaurant deleteRestaurant(@PathVariable("id") Integer id) {
        Optional<Restaurant> restaurantToDeleteOptional = this.restaurantRepository.findById(id);
        if (!restaurantToDeleteOptional.isPresent()) {
            return null;
        }
        Restaurant restaurantToDelete = restaurantToDeleteOptional.get();
        this.restaurantRepository.delete(restaurantToDelete);
        return restaurantToDelete;
    }
    @DeleteMapping("/restaurants/review/delete/{id}")
    public Review deleteReview(@PathVariable("id") Integer id) {
        Optional<Review> reviewToDeleteOptional = this.reviewRepository.findById(id);
        if (!reviewToDeleteOptional.isPresent()) {
            return null;
        }
        Review reviewToDelete = reviewToDeleteOptional.get();
        this.reviewRepository.delete(reviewToDelete);
        return reviewToDelete;
    }
    @DeleteMapping("/restaurants/user/delete/{id}")
    public Users deleteUser(@PathVariable("id") Integer id) {
        Optional<Users> userToDeleteOptional = this.usersRepository.findById(String.valueOf(id));
        if (!userToDeleteOptional.isPresent()) {
            return null;
        }
        Users userToDelete = userToDeleteOptional.get();
        this.usersRepository.delete(userToDelete);
        return userToDelete;
    }
}

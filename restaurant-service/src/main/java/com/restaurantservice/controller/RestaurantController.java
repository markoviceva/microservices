package com.restaurantservice.controller;

import com.restaurantservice.model.Restaurant;
import com.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public ResponseEntity<?> getRestaurants () {
        ResponseEntity<?> response;
        try {
            response = new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
        } catch (Exception exc) {
            exc.printStackTrace();
            response = new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<?> getRestaurant (@PathVariable Integer id) {
        ResponseEntity<?> response;
        try {
            response = new ResponseEntity<>(restaurantService.findById(id), HttpStatus.OK);
        } catch (Exception exc) {
            exc.printStackTrace();
            response = new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping("/restaurant")
    public ResponseEntity<?> getRestaurantByName (@RequestParam String name) {
        ResponseEntity<?> response;
        try {
            response = new ResponseEntity<>(restaurantService.findByName(name), HttpStatus.OK);
        } catch (Exception exc) {
            exc.printStackTrace();
            response = new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping("/restaurants-by-city")
    public ResponseEntity<?> getRestaurantsByCity (@RequestParam String city) {
        ResponseEntity<?> response;
        try {
            response = new ResponseEntity<>(restaurantService.findAllByCity(city), HttpStatus.OK);
        } catch (Exception exc) {
            exc.printStackTrace();
            response = new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping("/restaurant")
    public ResponseEntity<?> saveRestaurant(@RequestBody Restaurant restaurant) {
        ResponseEntity<?> response;
        try {
            response = new ResponseEntity<>(restaurantService.save(restaurant), HttpStatus.CREATED);
        } catch (Exception exc) {
            exc.printStackTrace();
            response = new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<?> deleteRestaurant (@PathVariable Integer id) {
        ResponseEntity<?> response;
        try {
            restaurantService.delete(id);
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exc) {
            exc.printStackTrace();
            response = new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}

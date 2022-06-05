package com.courierservice.controller;

import com.courierservice.model.Courier;
import com.courierservice.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @GetMapping("/couriers")
    public ResponseEntity<?> getCouriers() {
        ResponseEntity<?> response;
        try {
            response = new ResponseEntity<>(courierService.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            response = new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping("/courier")
    public ResponseEntity<?> getCourierByCode (@RequestParam String code) {
        ResponseEntity<?> response;
        try {
            response = new ResponseEntity<>(courierService.findByCode(code), HttpStatus.OK);
        } catch (Exception exception) {
            response = new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping("/courier")
    public ResponseEntity<?> addCourier(@RequestBody Courier courier) {
        ResponseEntity<?> response;
        try {
            response = new ResponseEntity<>(courierService.save(courier), HttpStatus.CREATED);
        } catch (Exception exception) {
            response = new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping("/courier/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id) {
        ResponseEntity<?> response;
        try {
            courierService.delete(id);
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            response = new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}

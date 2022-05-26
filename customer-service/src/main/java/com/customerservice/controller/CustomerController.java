package com.customerservice.controller;

import com.customerservice.model.Customer;
import com.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomers () {
        ResponseEntity<?> response;
        try {
            response = new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
        } catch (Exception exc) {
            exc.printStackTrace();
            response = new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping("/customer/{id}")    public ResponseEntity<?> getCustomer (@PathVariable Integer id) {
        ResponseEntity<?> response;
        try {
            response = new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
        } catch (Exception exc) {
            exc.printStackTrace();
            response = new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping("/customer")
    public ResponseEntity<?> saveCustomer (@RequestBody Customer customer) {
        ResponseEntity<?> response;
        try {
            response = new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
        } catch (Exception exc) {
            exc.printStackTrace();
            response = new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer (@PathVariable Integer id) {
        ResponseEntity<?> response;
        try {
            customerService.delete(id);
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exc) {
            exc.printStackTrace();
            response = new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}

package org.ayomide.controllers;

import org.ayomide.dto.request.LoginRequest;
import org.ayomide.dto.request.RegisterRequest;
import org.ayomide.dto.response.ApiResponse;
import org.ayomide.dto.response.LoginResponse;
import org.ayomide.dto.response.RegisterResponse;
import org.ayomide.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")

public class CustomerController {
private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request){
        try {
            RegisterResponse response = customerService.createUserAccount(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
   @PostMapping("/login-user")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request){
        try {
            LoginResponse response = customerService.loginUserAccount(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }
}

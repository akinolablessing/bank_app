package org.ayomide.controllers;

import lombok.AllArgsConstructor;
import org.ayomide.dto.request.TransactionRequest;
import org.ayomide.dto.response.ApiResponse;
import org.ayomide.dto.response.RegisterResponse;
import org.ayomide.dto.response.TransactionResponse;
import org.ayomide.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@AllArgsConstructor
public class TransactionOperationController {
    private final TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<?> depositMoney(@RequestBody TransactionRequest request){
        try {
            TransactionResponse response = transactionService.deposit(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/withdraw")
    public ResponseEntity<?> withdrawMoney(@RequestBody TransactionRequest request){
        try {
            TransactionResponse response = transactionService.withdraw(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity<?> transferMoney(@RequestBody TransactionRequest request){
        try {
            TransactionResponse response = transactionService.transfer(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

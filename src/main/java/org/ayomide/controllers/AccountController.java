package org.ayomide.controllers;

import org.ayomide.dto.request.AccountRequest;
import org.ayomide.dto.response.AccountResponse;
import org.ayomide.dto.response.ApiResponse;
import org.ayomide.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AccountController {
    private final AccountService accountService;

    public AccountController( AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/create-account")
    public ResponseEntity<?> createAccount(@RequestBody AccountRequest request){
        try {
            AccountResponse response = accountService.createBankAccount(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/findAccountNumber")
    public ResponseEntity<?> findAccountNumber(@RequestBody AccountRequest request){
        try {
            AccountResponse response = accountService.getAccountByNumber(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package org.ayomide.services;

import org.ayomide.data.model.Customer;
import org.ayomide.data.repositories.CustomerRepo;
import org.ayomide.dto.request.LoginRequest;
import org.ayomide.dto.request.RegisterRequest;
import org.ayomide.dto.response.LoginResponse;
import org.ayomide.dto.response.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.ayomide.validation.Validation.*;

@Service
public class CustomerService implements CustomerServiceInter{
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public RegisterResponse createUserAccount(RegisterRequest registerRequest) {
        RegisterResponse response = new RegisterResponse();
        Customer customer = new Customer();
        userNameValidation(registerRequest);
        customer.setFirstName(registerRequest.getFirstName());
        userNameValidation(registerRequest);
        customer.setLastName(registerRequest.getLastName());
        userPhoneNumberValidation(registerRequest);
        customer.setPhoneNumber(registerRequest.getPhoneNumber());
        emailValidation(registerRequest);
        customer.setUserGmail(registerRequest.getUserGmail());
        userPasswordValidation(registerRequest);
        customer.setPassword(registerRequest.getPassword());
        customer.setAddress(registerRequest.getAddress());
        customerRepo.save(customer);
        response.setMessage("Register successfully!!");
        return response;
    }

    @Override
    public LoginResponse loginUserAccount(LoginRequest loginRequest) {
        return null;
    }
}

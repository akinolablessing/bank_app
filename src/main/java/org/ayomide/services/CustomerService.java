package org.ayomide.services;

import org.ayomide.data.model.Customer;
import org.ayomide.data.repositories.CustomerRepo;
import org.ayomide.dto.request.LoginRequest;
import org.ayomide.dto.request.RegisterRequest;
import org.ayomide.dto.response.LoginResponse;
import org.ayomide.dto.response.RegisterResponse;
import org.ayomide.exception.LoginException;
import org.mindrot.jbcrypt.BCrypt;
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

        String hashPassword = BCrypt.hashpw(registerRequest.getPassword(), BCrypt.gensalt());
        customer.setPassword(hashPassword);
        customer.setAddress(registerRequest.getAddress());
        customerRepo.save(customer);
        response.setMessage("Register successfully!!");
        return response;
    }

    @Override
    public LoginResponse loginUserAccount(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        Customer customer = customerRepo. findByUserGmail(loginRequest.getUserGmail());
        if(customer.getUserGmail().equals(loginRequest.getUserGmail())
        && customer.getPhoneNumber().equals(loginRequest.getPhoneNumber())
        && BCrypt.checkpw(loginRequest.getPassword(), customer.getPassword())){
        customer.setLogin(true);
        customerRepo.save(customer);
        }
        else {
            throw new LoginException("Invalid Credential!!");
        }
        loginResponse.setMessage("Login Successfully");
        return loginResponse;
        }

    }


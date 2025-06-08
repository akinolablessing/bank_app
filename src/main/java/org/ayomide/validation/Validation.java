package org.ayomide.validation;

import org.ayomide.data.model.Status;
import org.ayomide.data.model.TransactionType;
import org.ayomide.data.repositories.AccountRepository;
import org.ayomide.dto.request.AccountRequest;
import org.ayomide.dto.request.RegisterRequest;
import org.ayomide.exception.*;
import org.springframework.beans.factory.annotation.Autowired;

public class Validation {



    public static void emailValidation(RegisterRequest request){
    if(!request.getUserGmail().contains("@gmail.com")){
        throw new UserGmailValidation("Invalid gmail!!");
    }
    }
    public static void userNameValidation(RegisterRequest request){
        if(request.getFirstName().isEmpty()|| request.getLastName().isEmpty()){
           throw new UserNameValidation("Name cannot be empty!!");
        }
    }
    public static void userPhoneNumberValidation(RegisterRequest request){
        if(request.getPhoneNumber().length()>11){
            throw new UserPhoneNumberValidation("Phone number should not be more than 11 digit!!");
        }
    }
    public static void userPasswordValidation(RegisterRequest request){
        if(request.getPassword().isEmpty()){
            throw new UserValidationPassword("Password cannot be empty!!");
        }
        if(request.getPassword().length() > 6){
           throw new UserValidationPassword("Password should be 6-digit number!!");
        }
    }
    public static void statusTypeValidation(Status status){
       if(!Status.SUCCESS.equals(status)){
           throw new StatusTypeValidation("Transaction Failed");
       }
    }
    public static void transactionTypeForWithdrawValidation(TransactionType type){
        if(!TransactionType.WITHDRAWAL.equals(type)){
            throw new TransactionTypeValidation("Transaction Type should me withdraw");
        }
    }
}

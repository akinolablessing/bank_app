package org.ayomide.validation;

import org.ayomide.dto.request.RegisterRequest;
import org.ayomide.exception.UserGmailValidation;
import org.ayomide.exception.UserNameValidation;
import org.ayomide.exception.UserPhoneNumberValidation;
import org.ayomide.exception.UserValidationPassword;

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
}

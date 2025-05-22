package org.ayomide.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String userGmail;
    private String phoneNumber;
    private String password;
    private String address;
}

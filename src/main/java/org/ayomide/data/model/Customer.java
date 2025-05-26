package org.ayomide.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Customer {
    @Id
    private String customerId;

    private String firstName;
    private String lastName;
    private String userGmail;
    private String phoneNumber;
    private String password;
    private String address;
    private boolean isLogin;
}

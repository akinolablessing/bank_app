package org.ayomide.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String userGmail;
    private String phoneNumber;
    private String password;

}

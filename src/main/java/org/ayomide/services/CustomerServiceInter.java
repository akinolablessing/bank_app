package org.ayomide.services;

import org.ayomide.dto.request.LoginRequest;
import org.ayomide.dto.request.RegisterRequest;
import org.ayomide.dto.response.LoginResponse;
import org.ayomide.dto.response.RegisterResponse;

public interface CustomerServiceInter {

    RegisterResponse createUserAccount(RegisterRequest registerRequest);
   LoginResponse loginUserAccount(LoginRequest loginRequest);
}

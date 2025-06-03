package org.ayomide.controllers;

import org.ayomide.dto.request.OtpRequest;
import org.ayomide.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/otp")
public class OtpController {

        @Autowired
        private EmailService emailService;

    @PostMapping("/send")
    public String sendOtp(@RequestBody OtpRequest request) {
        String otp = emailService.sendOtp(request.getEmail());
        return "OTP sent to " + request.getEmail();
    }
}

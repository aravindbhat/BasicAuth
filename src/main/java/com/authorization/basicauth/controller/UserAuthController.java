package com.authorization.basicauth.controller;

import com.authorization.basicauth.dto.ApplicationUserLoginDto;
import com.authorization.basicauth.dto.ApplicationUsersRequestDto;
import com.authorization.basicauth.dto.ApplicationUsersResponseDto;
import com.authorization.basicauth.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/signup")
    public ResponseEntity<ApplicationUsersResponseDto> signup(@RequestBody ApplicationUsersRequestDto applicationUsersRequestDto){
        return ResponseEntity.ok(userAuthService.signup(applicationUsersRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<ApplicationUsersResponseDto> login(@RequestBody ApplicationUserLoginDto applicationUserLoginDto){
        return ResponseEntity.ok(userAuthService.login(applicationUserLoginDto));
    }


}

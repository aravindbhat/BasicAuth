package com.authorization.basicauth.service;

import com.authorization.basicauth.dto.ApplicationUserLoginDto;
import com.authorization.basicauth.dto.ApplicationUsersRequestDto;
import com.authorization.basicauth.dto.ApplicationUsersResponseDto;
import com.authorization.basicauth.entity.ApplicationUsers;
import com.authorization.basicauth.repository.UserAuthRepo;
import com.authorization.basicauth.util.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAuthService {
    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private UserAuthRepo userAuthRepo;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private AuthUtil authUtil;

    public ApplicationUsersResponseDto signup(ApplicationUsersRequestDto applicationUsersRequestDto) {
        ApplicationUsers newUser = userAuthRepo.findByUserName(applicationUsersRequestDto.getUserName()).orElse(null);
        if(newUser!=null)
            throw new IllegalArgumentException("User Already Exist");
        newUser = userAuthRepo.save(ApplicationUsers.builder().userName(applicationUsersRequestDto.getUserName())
                .userEncryptedPassword(passwordEncoder.encode(applicationUsersRequestDto.getPassword()))
                .mailId(applicationUsersRequestDto.getMailId())
                .phoneNumber(applicationUsersRequestDto.getPhoneNumber())
                .userRole("STANDARDUSER")
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .lastLogin(new Timestamp(System.currentTimeMillis())).build());
        return login(new ApplicationUserLoginDto(applicationUsersRequestDto.getUserName(),applicationUsersRequestDto.getPassword()));
    }

    public ApplicationUsersResponseDto login(ApplicationUserLoginDto applicationUserLoginDto) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(applicationUserLoginDto.getUserName(),applicationUserLoginDto.getPassword())
        );
        ApplicationUsers applicationUsers=(ApplicationUsers) authentication.getPrincipal();
        System.out.println(applicationUsers);
        userAuthRepo.updateLatestLoginTime(applicationUsers.getUserId(), new Timestamp(System.currentTimeMillis()));
        String token=authUtil.generateAccessToken(applicationUsers);
        return new ApplicationUsersResponseDto(applicationUsers.getUserName(), token, new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()+10*60*1000));
    }
}

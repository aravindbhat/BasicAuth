package com.authorization.basicauth.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApplicationUserLoginDto {
    private String userName;
    private String password;

}

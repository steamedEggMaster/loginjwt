package com.example.loginjwt.swagger;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @PackageName : com.example.loginjwt.swagger
 * @FileName : LoginRequest
 * @Author : noglass_gongdae
 * @Date : 2024-07-18
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */
@Schema(description = "Login request")
public class LoginRequest {
    @Schema(description = "User's username", example = "user", required = true)
    private String username;

    @Schema(description = "User's password", example = "password", required = true)
    private String password;

    // getters and setters
}

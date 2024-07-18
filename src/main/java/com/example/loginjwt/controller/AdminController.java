package com.example.loginjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName : com.example.loginjwt.controller
 * @FileName : AdminController
 * @Author : noglass_gongdae
 * @Date : 2024-07-18
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */

@RestController
public class AdminController {

    @GetMapping("/admin")
    public String adminP() {
        return "admin controller";
    }

}

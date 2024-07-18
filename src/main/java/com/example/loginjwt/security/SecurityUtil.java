package com.example.loginjwt.security;

import com.example.loginjwt.dto.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @PackageName : com.example.loginjwt.security
 * @FileName : SecurityUtil
 * @Author : noglass_gongdae
 * @Date : 2024-07-18
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */
@Component
public class SecurityUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtil.class);
    public String getCurrentUsername(){
        LOGGER.info("-------getCurrentUsername Start--------");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
            LOGGER.info("-------getCurrentUsername End--------");
            return customUserDetails.getUsername();
        }
        LOGGER.info("-------getCurrentUsername null--------");
        return null;
    }
}

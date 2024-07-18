package com.example.loginjwt.repository;

import com.example.loginjwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @PackageName : com.example.loginjwt.repository
 * @FileName : UserRepository
 * @Author : noglass_gongdae
 * @Date : 2024-07-18
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Boolean existsByUsername(String username);

    //username을 받아 DB 테이블에서 회원을 조회하는 메소드 작성
    UserEntity findByUsername(String username);

}

package com.example.user.service;

import com.example.user.dto.UserDto;
import com.example.user.jpa.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();

    UserDto getUserDetailsByEmail(String username); // email -> user-id 반환 맵핑을 위한 메소드
}

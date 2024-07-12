package com.example.user.service;

import com.example.user.dto.UserDto;
import com.example.user.jpa.UserEntity;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}

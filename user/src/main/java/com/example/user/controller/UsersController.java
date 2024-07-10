package com.example.user.controller;

import com.example.user.dto.UserDto;
import com.example.user.entity.UserEntity;
import com.example.user.service.UserService;
import com.example.user.vo.RequestUser;
import com.example.user.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UsersController {

    private final Environment environment;
    private final UserService userService;

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's Working in User Service on PORT %s" ,
                environment.getProperty("local.server.port"));
    }

    @GetMapping("/welcome")
    public String welcome(){
        return environment.getProperty("greeting.message");
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody RequestUser user){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user, UserDto.class);
        UserDto returnUserDto = userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(returnUserDto, ResponseUser.class);
        return  new ResponseEntity(HttpStatus.CREATED).ok(responseUser);
    }
}

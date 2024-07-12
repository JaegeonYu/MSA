package com.example.user.controller;

import com.example.user.dto.UserDto;
import com.example.user.jpa.UserEntity;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-service")
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

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers(){
        Iterable<UserEntity> userList = userService.getUserByAll();

        List<ResponseUser> result = new ArrayList<>();

        userList.forEach(v -> result.add(new ModelMapper().map(v, ResponseUser.class)));

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable String userId){
        UserDto userDto = userService.getUserByUserId(userId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ModelMapper().map(userDto, ResponseUser.class));
    }
}

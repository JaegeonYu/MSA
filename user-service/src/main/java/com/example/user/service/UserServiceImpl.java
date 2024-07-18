package com.example.user.service;

import com.example.user.client.OrderServiceClient;
import com.example.user.dto.UserDto;
import com.example.user.jpa.UserEntity;
import com.example.user.jpa.UserRepository;
import com.example.user.vo.ResponseOrder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final OrderServiceClient orderServiceClient;

    @Override
    public UserDto createUser(UserDto user) {
        user.setUserId(UUID.randomUUID().toString());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity.setEncryptedPwd(passwordEncoder.encode(user.getPwd()));
        userRepository.save(userEntity);

        return mapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);

        if(userEntity == null)throw new UsernameNotFoundException("User Not Found");

        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);

        // TODO order service 구현
        List<ResponseOrder> orders = orderServiceClient.getOrders(userId);

        userDto.setOrders(orders);

        return userDto;
    }

    @Override
    public Iterable<UserEntity> getUserByAll() {
        return userRepository.findAll();
    }

    @Override // userDetailService -> DB 찾기
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null)throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(), userEntity.getEncryptedPwd(), true, true,
                true, true,new ArrayList<>());
    }

    @Override // email -> user-id 반환 맵핑을 위한 메소드
    public UserDto getUserDetailsByEmail(String email){
        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null)throw new UsernameNotFoundException(email);

        return new ModelMapper().map(userEntity, UserDto.class);

    }
}

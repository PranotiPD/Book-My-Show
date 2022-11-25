package com.example.BookMyShow.service.impl;


import com.example.BookMyShow.converter.UserConverter;
import com.example.BookMyShow.dto.entryDto.UserEntryDto;
import com.example.BookMyShow.dto.responseDto.UserResponseDto;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.repository.UserRepository;
import com.example.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDto addUser(UserEntryDto userEntryDto) {

        User user = UserConverter.covertDtoToUser(userEntryDto);

        userRepository.save(user);

        UserResponseDto userResponseDto = UserConverter.convertUserToDto(user);

        return userResponseDto;
    }

    @Override
    public UserResponseDto getUser(int id) {
        User user = userRepository.findById(id).get();
        UserResponseDto userResponseDto = UserConverter.convertUserToDto(user);
        return userResponseDto;
    }
}

package com.example.BookMyShow.service;


import com.example.BookMyShow.dto.entryDto.UserEntryDto;
import com.example.BookMyShow.dto.responseDto.UserResponseDto;

public interface UserService {

    UserResponseDto addUser(UserEntryDto userEntryDto);

    UserResponseDto getUser(int id);
}

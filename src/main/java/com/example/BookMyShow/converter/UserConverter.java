package com.example.BookMyShow.converter;

import com.example.BookMyShow.dto.entryDto.UserEntryDto;
import com.example.BookMyShow.dto.responseDto.UserResponseDto;
import com.example.BookMyShow.models.User;

public class UserConverter {

    public static User covertDtoToUser(UserEntryDto userEntryDto){
        return User.builder().name(userEntryDto.getName()).mobile(userEntryDto.getMobile()).build();
    }

    public static UserResponseDto convertUserToDto(User user){
        return UserResponseDto.builder().id(user.getId()).name(user.getName()).mobile(user.getMobile()).build();
    }
}

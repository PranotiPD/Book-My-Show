package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.entryDto.UserEntryDto;
import com.example.BookMyShow.dto.responseDto.UserResponseDto;
import com.example.BookMyShow.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("add")
    public UserResponseDto adduser(@RequestBody()UserEntryDto userEntryDto){
        return userServiceImpl.addUser(userEntryDto);
    }

    @GetMapping("{id}")
    public UserResponseDto getUser(@PathVariable() Integer id){
        return userServiceImpl.getUser(id);
    }

}

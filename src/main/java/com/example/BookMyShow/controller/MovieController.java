package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.entryDto.MovieEntryDto;
import com.example.BookMyShow.dto.responseDto.MovieResponseDto;
import com.example.BookMyShow.service.MovieService;
import com.example.BookMyShow.service.impl.MovieServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
@Slf4j //this annotation is for log info
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("add")
    MovieResponseDto addMovie(@RequestBody() MovieEntryDto movieEntryDto){
        MovieResponseDto movieResponseDto = movieService.addMovie(movieEntryDto);
        log.info("The movieResponseDto is ",movieResponseDto);
        return movieResponseDto;
    }

    @GetMapping("get")
    MovieResponseDto getMovie(@RequestParam() Integer id){
        MovieResponseDto movieResponseDto = movieService.getMovie(id);
        return movieResponseDto;
    }

}

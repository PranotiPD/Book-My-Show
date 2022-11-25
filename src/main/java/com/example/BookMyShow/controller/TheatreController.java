package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.entryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.responseDto.TheatreResponseDto;
import com.example.BookMyShow.service.TheatreService;
import com.example.BookMyShow.service.impl.TheatreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("theatre")
public class TheatreController {

    @Autowired
    TheatreServiceImpl theatreService;

    @PostMapping("add")
    public ResponseEntity<String> addTheatre(@RequestBody() TheatreEntryDto theatreEntryDto){
        log.info("In theatre controller");
        theatreService.addTheatre(theatreEntryDto);

        return new ResponseEntity("success",HttpStatus.CREATED);
    }
}

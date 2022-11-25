package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.entryDto.ShowEntryDto;
import com.example.BookMyShow.dto.responseDto.ShowResponseDto;
import com.example.BookMyShow.service.impl.ShowServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    ShowServiceImpl showService;

    @PostMapping("add")
    public ShowResponseDto addShow(@RequestBody() ShowEntryDto showEntryDto){
         log.info("In Show Controller");
         return showService.addShow(showEntryDto);
    }

}

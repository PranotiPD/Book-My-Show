package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.BookTicketRequestDto;
import com.example.BookMyShow.dto.responseDto.TicketResponseDto;
import com.example.BookMyShow.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping("add")
    public TicketResponseDto addTicket(@RequestBody()BookTicketRequestDto bookTicketRequestDto){

        return ticketService.bookTicket(bookTicketRequestDto);
    }

    @GetMapping("get/{id}")
    public TicketResponseDto getTicket(@PathVariable Integer id){
        return ticketService.getTicket(id);
    }

}

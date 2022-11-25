package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.BookTicketRequestDto;
import com.example.BookMyShow.dto.responseDto.TicketResponseDto;

public interface TicketService {

    TicketResponseDto getTicket(int id);

    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);
}

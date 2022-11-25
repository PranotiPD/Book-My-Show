package com.example.BookMyShow.converter;


import com.example.BookMyShow.dto.entryDto.TicketEntryDto;
import com.example.BookMyShow.dto.responseDto.TicketResponseDto;
import com.example.BookMyShow.models.Tickets;


public class TicketConverter {

    public static TicketResponseDto convertTicketToDto(Tickets ticket){

        return TicketResponseDto.builder().id(ticket.getId()).allocated_seats(ticket.getAllocatedSeats()).
                amount(ticket.getAmount()).build();
    }
}

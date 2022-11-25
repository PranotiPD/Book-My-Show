package com.example.BookMyShow.dto.entryDto;


import com.example.BookMyShow.dto.responseDto.ShowResponseDto;
import com.example.BookMyShow.dto.responseDto.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TicketEntryDto {
    int id;

    String allocated_seats;

    double amount;

    ShowResponseDto showResponseDto;

    @NotNull
    UserResponseDto userResponseDto;
}

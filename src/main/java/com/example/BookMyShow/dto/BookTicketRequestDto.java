package com.example.BookMyShow.dto;

import com.example.BookMyShow.enums.SeatType;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class BookTicketRequestDto {

    Set<String> requested_seats;

    int showId;

    int id;

    SeatType seatType;

}

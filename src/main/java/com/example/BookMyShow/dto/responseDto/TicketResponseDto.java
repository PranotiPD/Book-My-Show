package com.example.BookMyShow.dto.responseDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TicketResponseDto {

    int id;
    String allocated_seats;
    double amount;
}

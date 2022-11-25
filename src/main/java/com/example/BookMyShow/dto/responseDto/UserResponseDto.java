package com.example.BookMyShow.dto.responseDto;

import com.example.BookMyShow.models.Tickets;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {

    int id;
    String name;
    String mobile;

    List<Tickets> ticketsList;
}

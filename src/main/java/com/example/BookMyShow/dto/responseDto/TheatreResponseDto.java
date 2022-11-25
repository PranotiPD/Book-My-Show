package com.example.BookMyShow.dto.responseDto;

import com.example.BookMyShow.enums.TheatreType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreResponseDto {

    int id;
    String name;
    String address;
    String city;
    TheatreType type;
}

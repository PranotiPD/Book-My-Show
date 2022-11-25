package com.example.BookMyShow.dto.responseDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MovieResponseDto {

    int id;
    String name;
    LocalDate releaseDate;

    //optional
    //List<ShowResponseDto> showDtoList;
}

package com.example.BookMyShow.converter;

import com.example.BookMyShow.dto.entryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.responseDto.TheatreResponseDto;
import com.example.BookMyShow.models.Theatre;

public class TheatreConverter {

    public static Theatre convertDtoToTheatre(TheatreEntryDto theatreEntryDto){
        return Theatre.builder().name(theatreEntryDto.getName()).city(theatreEntryDto.getCity()).
        address(theatreEntryDto.getAddress()).build();
    }

    public static TheatreResponseDto convertTheatreToDto(Theatre theatre){
        return TheatreResponseDto.builder().id(theatre.getId()).name(theatre.getName()).city(theatre.getCity()).
        address(theatre.getAddress()).type(theatre.getType()).build();
    }
}

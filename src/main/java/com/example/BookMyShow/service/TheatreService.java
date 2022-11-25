package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.entryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.responseDto.TheatreResponseDto;

public interface TheatreService {
    TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto);

    TheatreResponseDto getTheatre(int id);
}

package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.entryDto.MovieEntryDto;
import com.example.BookMyShow.dto.responseDto.MovieResponseDto;
import com.example.BookMyShow.models.Movie;

public interface MovieService {

    // add movie
    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);

    //get movie

    MovieResponseDto getMovie(int id);
}

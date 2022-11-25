package com.example.BookMyShow.converter;

import com.example.BookMyShow.dto.entryDto.MovieEntryDto;
import com.example.BookMyShow.dto.responseDto.MovieResponseDto;
import com.example.BookMyShow.models.Movie;

public class MovieConverter {

    public static Movie convertDtoToMovie(MovieEntryDto movieEntryDto){

        return Movie.builder().name(movieEntryDto.getName()).releaseDate(movieEntryDto.getReleaseDate()).build();
    }

    public static MovieResponseDto convertMovieToDto(Movie movie){

        return MovieResponseDto.builder().id(movie.getId()).releaseDate(movie.getReleaseDate()).name(movie.getName()).build();
    }
}

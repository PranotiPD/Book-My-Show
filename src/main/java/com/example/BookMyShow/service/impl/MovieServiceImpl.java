package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.converter.MovieConverter;
import com.example.BookMyShow.dto.entryDto.MovieEntryDto;
import com.example.BookMyShow.dto.responseDto.MovieResponseDto;
import com.example.BookMyShow.models.Movie;
import com.example.BookMyShow.repository.MovieRepository;
import com.example.BookMyShow.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {
        MovieResponseDto movieResponseDto = null;

        // if movie already exist then we won't be adding it
        if(movieRepository.existsByName(movieEntryDto.getName())){
            movieResponseDto.setName("This movie already exist");
            return movieResponseDto;
        }
        log.info("In the function add movie" + movieEntryDto);
        Movie movie = MovieConverter.convertDtoToMovie(movieEntryDto);
        movie = movieRepository.save(movie);

        movieResponseDto = MovieConverter.convertMovieToDto(movie);
        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovie(int id) {

        Movie movie = movieRepository.findById(id).get();
        MovieResponseDto movieResponseDto = MovieConverter.convertMovieToDto(movie);
        return movieResponseDto;
    }
}

package com.example.BookMyShow.service.impl;


import com.example.BookMyShow.controller.ShowController;
import com.example.BookMyShow.converter.ShowConverter;
import com.example.BookMyShow.dto.entryDto.ShowEntryDto;
import com.example.BookMyShow.dto.responseDto.ShowResponseDto;
import com.example.BookMyShow.models.*;
import com.example.BookMyShow.repository.MovieRepository;
import com.example.BookMyShow.repository.ShowRepository;
import com.example.BookMyShow.repository.ShowSeatsRepository;
import com.example.BookMyShow.repository.TheatreRepository;
import com.example.BookMyShow.service.ShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {
        // first covert dto to show entity
        Show show = ShowConverter.covertDtoToShow(showEntryDto);

        // now get movie from repository
        Movie movie = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();

        //now get theatre from repository
        Theatre theatre = theatreRepository.findById(showEntryDto.getTheatreResponseDto().getId()).get();

        //set movie and theatre in show entity
        show.setMovie(movie);
        show.setTheatre(theatre);

        //now save show in repository
        show = showRepository.save(show);

        //We need to pass the list of the theater seats and that's how we will map them to show seats
        generateShowSeats(theatre.getSeats(),show);

        ShowResponseDto showResponseDto = ShowConverter.convertShowToDto(show, showEntryDto);
        return showResponseDto;

    }

    public void generateShowSeats(List<TheatreSeats> theatreSeatsList, Show show){

        //create list of type showseats
        List<ShowSeats> showSeatsList = new ArrayList<>();

        log.info("List of theatreSeats ");
        for(TheatreSeats ts: theatreSeatsList){
            log.info(ts.toString());
        }

        for(TheatreSeats ts : theatreSeatsList){
            ShowSeats showSeats = ShowSeats.builder().seatNumber(ts.getSeatNumber()).seatType(ts.getSeatType()).
            rate(ts.getRate()).build();

            showSeatsList.add(showSeats);
        }

        for(ShowSeats showSeats : showSeatsList){
            showSeats.setShow(show);
        }

        showSeatsRepository.saveAll(showSeatsList);

        show.setShowSeatsList(showSeatsList);
    }
}

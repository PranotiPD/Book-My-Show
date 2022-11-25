package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.converter.TheatreConverter;
import com.example.BookMyShow.dto.entryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.responseDto.TheatreResponseDto;
import com.example.BookMyShow.enums.SeatType;
import com.example.BookMyShow.enums.TheatreType;
import com.example.BookMyShow.models.Theatre;
import com.example.BookMyShow.models.TheatreSeats;
import com.example.BookMyShow.repository.TheatreRepository;
import com.example.BookMyShow.repository.TheatreSeatsRepository;
import com.example.BookMyShow.service.TheatreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatsRepository theatreSeatsRepository;

    @Override
    public TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto) {
        // dto to theatre
        Theatre theatre = TheatreConverter.convertDtoToTheatre(theatreEntryDto);

        //create theatre seats for theatre
        List<TheatreSeats> theatreSeatsList = createTheatreSeats();

        //setting seats of theatre
        theatre.setSeats(theatreSeatsList);

        //setting shows null as of now
        theatre.setShows(null);

        //now setting theatre for those created seats
        for(TheatreSeats seats : theatreSeatsList){
            seats.setTheatre(theatre);
        }
        theatre.setType(TheatreType.Multiplex);

        // logs
        log.info("Theatre entity logs are here"+theatre);

        //now save this theatre in repo
        theatre = theatreRepository.save(theatre);

        //now convert this theatre to response
        TheatreResponseDto theatreResponseDto = TheatreConverter.convertTheatreToDto(theatre);
        return theatreResponseDto;
    }

    List<TheatreSeats>  createTheatreSeats(){

        List<TheatreSeats> seats = new ArrayList<>();

        seats.add(getTheatreSeat("1A",100,SeatType.Classic));
        seats.add(getTheatreSeat("1B",100,SeatType.Classic));
        seats.add(getTheatreSeat("1C",100,SeatType.Classic));
        seats.add(getTheatreSeat("1D",100,SeatType.Classic));
        seats.add(getTheatreSeat("1E",100,SeatType.Classic));
        seats.add(getTheatreSeat("1F",100,SeatType.Classic));

        seats.add(getTheatreSeat("2A",100,SeatType.Premium));
        seats.add(getTheatreSeat("2B",100,SeatType.Premium));
        seats.add(getTheatreSeat("2C",100,SeatType.Premium));
        seats.add(getTheatreSeat("2D",100,SeatType.Premium));
        seats.add(getTheatreSeat("2E",100,SeatType.Premium));
        seats.add(getTheatreSeat("2F",100,SeatType.Premium));

        theatreSeatsRepository.saveAll(seats);

        return seats;
    }

    TheatreSeats getTheatreSeat(String seatName, int rate, SeatType seatType){

        return TheatreSeats.builder().seatNumber(seatName).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheatreResponseDto getTheatre(int id){
        Theatre theatre = theatreRepository.findById(id).get();

        TheatreResponseDto theatreResponseDto = TheatreConverter.convertTheatreToDto(theatre);
        return theatreResponseDto;
    }
}

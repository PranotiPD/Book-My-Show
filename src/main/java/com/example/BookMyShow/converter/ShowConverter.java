package com.example.BookMyShow.converter;

import com.example.BookMyShow.dto.entryDto.ShowEntryDto;
import com.example.BookMyShow.dto.responseDto.ShowResponseDto;
import com.example.BookMyShow.models.Show;


public class ShowConverter {

    public static Show covertDtoToShow(ShowEntryDto showEntryDto){
        return Show.builder().showTime(showEntryDto.getShowTime()).showDate(showEntryDto.getShowDate()).build();
    }

    public static ShowResponseDto convertShowToDto(Show show, ShowEntryDto showEntryDto){
        return ShowResponseDto.builder().id(show.getId()).showDate(show.getShowDate()).
             showTime(show.getShowTime()).movieResponseDto(showEntryDto.getMovieResponseDto())
                .theatreResponseDto(showEntryDto.getTheatreResponseDto()).build();
    }
}

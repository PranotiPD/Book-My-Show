package com.example.BookMyShow.dto.entryDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MovieEntryDto {

    String name;
    LocalDate releaseDate;
}

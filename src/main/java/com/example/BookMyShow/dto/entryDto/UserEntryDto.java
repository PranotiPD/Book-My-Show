package com.example.BookMyShow.dto.entryDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntryDto {

    String name;
    String mobile;
}

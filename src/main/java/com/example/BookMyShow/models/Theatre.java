package com.example.BookMyShow.models;

import com.example.BookMyShow.enums.TheatreType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "theatre")
@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Show> shows;

    TheatreType type;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheatreSeats> seats = new ArrayList<>();



}

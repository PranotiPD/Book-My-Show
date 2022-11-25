package com.example.BookMyShow.service.impl;


import com.example.BookMyShow.converter.TicketConverter;
import com.example.BookMyShow.dto.BookTicketRequestDto;
import com.example.BookMyShow.dto.responseDto.TicketResponseDto;
import com.example.BookMyShow.models.Show;
import com.example.BookMyShow.models.ShowSeats;
import com.example.BookMyShow.models.Tickets;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.repository.ShowRepository;
import com.example.BookMyShow.repository.TicketRepository;
import com.example.BookMyShow.repository.UserRepository;
import com.example.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto getTicket(int id) {
        Tickets ticket = ticketRepository.findById(id).get();

        TicketResponseDto ticketResponseDto = TicketConverter.convertTicketToDto(ticket);

        return ticketResponseDto;
    }

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {

        //we need user id from userrepo
        User user = userRepository.findById(bookTicketRequestDto.getId()).get();
        //we need show id from showrepo
        Show show = showRepository.findById(bookTicketRequestDto.getId()).get();

        Set<String> requestedSeats = bookTicketRequestDto.getRequested_seats();

        List<ShowSeats> showSeatsList = show.getShowSeatsList();


        //adding booked seats
        List<ShowSeats> bookedSeats = showSeatsList
                .stream()
                .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&!seat.isBooked()&&
                        requestedSeats.contains(seat.getSeatNumber()))
                .collect(Collectors.toList());

        if(bookedSeats.size()!=requestedSeats.size()){
            //Al the seats were not avaiable
            throw new Error("All Seats not available");
        }

        //Step 2

        Tickets tickets = Tickets.builder().
                user(user)
                .show(show)
                .showSeats(bookedSeats).
                build();



        //Step 3 :

        double amount = 0;

        for(ShowSeats showSeatsEntity: bookedSeats){

            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedAt(new Date());
            showSeatsEntity.setTicket(tickets);

            amount = amount + showSeatsEntity.getRate();
        }

        tickets.setBookedAt(new Date());
        tickets.setAllocatedSeats(convertListOfSeatsEntityToString(bookedSeats));
        tickets.setAmount(amount);

        //Connect in thw Show and the user

        show.getTicketsList().add(tickets);


        //Add the ticket in the tickets list of the user Entity
        user.getTickets().add(tickets);


        tickets = ticketRepository.save(tickets);

        return TicketConverter.convertTicketToDto(tickets);
    }
    public String convertListOfSeatsEntityToString(List<ShowSeats> bookedSeats){
        String str = "";
        for(ShowSeats showSeatsEntity : bookedSeats){

            str = str + showSeatsEntity.getSeatNumber()+" ";
        }

        return str;
    }
}

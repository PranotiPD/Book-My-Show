package com.example.BookMyShow.repository;


import com.example.BookMyShow.models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TicketRepository extends JpaRepository<Tickets,Integer> {

}

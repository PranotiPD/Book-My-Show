package com.example.BookMyShow.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(value = { AuditingEntityListener.class })
@Builder
@Table(name = "ticket")
@Entity
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "allocated_seats", nullable = false)
    private String allocatedSeats;

    @Column(name = "amount", nullable = false)
    private double amount;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "booked_at", nullable = false)
    private Date bookedAt;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private Show show;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeats> showSeats;
}

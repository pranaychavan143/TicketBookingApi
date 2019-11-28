package com.tst.ticketbookingmanagmentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tst.ticketbookingmanagmentapp.entity.Ticket;

@Repository
public interface TicketBookingRepository extends JpaRepository<Ticket, Long> {

}

package com.tst.ticketbookingmanagmentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tst.ticketbookingmanagmentapp.entity.Ticket;
import com.tst.ticketbookingmanagmentapp.repository.TicketBookingRepository;

@Service
public class TicketBookingService {
   @Autowired
	private TicketBookingRepository ticketBookingRepository;
	
	
	public Ticket createTicket(Ticket ticket) {
		
		return ticketBookingRepository.save(ticket);
	}
	
	public Ticket getTicketById(Long ticketId) {
		return ticketBookingRepository.getOne(ticketId);
	}

	public List<Ticket> getAllTicketDetails() {
		
		return ticketBookingRepository.findAll();
	}

	


	public void ticketDeleteById(Long ticketId) {
	ticketBookingRepository.deleteById(ticketId);	
	}

	public Ticket updateTicketById(Ticket ticket) {
		Optional <Ticket> ticketDb = this.ticketBookingRepository.findById(ticket.getTicketId());
		Ticket ticketUpdate = ticketDb.get();   
		if(ticketDb.isPresent())
		    {
		    	
		    	ticketUpdate.setTicketId(ticket.getTicketId());
		    	ticketUpdate.setPassangerName(ticket.getPassangerName());
		    	ticketUpdate.setBookingDate(ticket.getBookingDate());
		    	ticketUpdate.setSourceStation(ticket.getSourceStation());
		    	ticketUpdate.setDestanationStation(ticket.getDestanationStation());
		    	ticketUpdate.setEmail(ticket.getEmail());
		    	ticketBookingRepository.save(ticketUpdate);
		    	
		    }
		 return ticketUpdate;
	}

	
	
}

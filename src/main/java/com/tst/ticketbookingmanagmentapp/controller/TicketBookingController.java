package com.tst.ticketbookingmanagmentapp.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tst.ticketbookingmanagmentapp.entity.Ticket;
import com.tst.ticketbookingmanagmentapp.service.TicketBookingService;

@RestController
@RequestMapping("/ticket")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;
	
	@PostMapping("/bookticket")
	public Ticket createTicket(@Valid @RequestBody Ticket ticket) {
		return ticketBookingService.createTicket(ticket);
		
	}
	
	@GetMapping("/bookingdeatail/{ticketId}")
	public ResponseEntity<Ticket>  getTicketById(@PathVariable Long ticketId) {
		Ticket ticket=ticketBookingService.getTicketById(ticketId);
		if(ticket==null) {
			return new ResponseEntity<Ticket>(ticket,HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
		}
	}
	
	@GetMapping("/bookingDetail")
    public  List<Ticket> getTicketDetail()
    {
		return ticketBookingService.getAllTicketDetails();
		
    }
	
	@PutMapping("/updateTicket/{ticketId}")
	public ResponseEntity<Ticket> updateTicketById(@PathVariable("ticketId") Long ticketId , @RequestBody Ticket ticket)
	{
		ticket.setTicketId(ticketId);
		return ResponseEntity.ok().body(this.ticketBookingService.updateTicketById(ticket));
		
	}
	
  @DeleteMapping("/deleteTicket/{ticketId}")
  public  ResponseEntity<Void> ticketDeleteById(@PathVariable ("ticketId") Long ticketId){
	  ticketBookingService.ticketDeleteById(ticketId);
		System.out.println("Record Update");
	  return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	  
  }
	
}

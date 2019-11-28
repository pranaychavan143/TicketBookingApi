package com.tst.ticketbookingmanagmentapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TicketBooking")
@JsonIgnoreProperties({"hibernateLazyInitializer", "Haandler"})
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_Id")
	private Long ticketId;
	
	@Column(name = "passanger_name" )
	@NotBlank
	private String passangerName;
	
	@Column(name = "booking_date" )
	@JsonFormat(pattern="yyyy-MM-dd")

	private Date bookingDate;
	
	@Column(name = "source_station")
	@NotBlank
	private String sourceStation;
	
	@Column(name = "dest_statiion" )
	@NotBlank
	private String destanationStation;
	
	@Column(name = "emailId" )
	@NotBlank
	private String email;
	
	
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public String getPassangerName() {
		return passangerName;
	}
	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}
	public Date getBookingDate() {
		return  bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
	     bookingDate = new Date();
		this.bookingDate = bookingDate;
	}
	public String getSourceStation() {
		return sourceStation;
	}
	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}
	public String getDestanationStation() {
		return destanationStation;
	}
	public void setDestanationStation(String destanationStation) {
		this.destanationStation = destanationStation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}

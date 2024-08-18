package com.movie.ticket.booking.service.payment.services.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.ticket.booking.service.payment.services.dto.BookingDTO;
import com.movie.ticket.booking.service.payment.services.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentRestController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/")
	public BookingDTO createPayment(@RequestBody BookingDTO bookingDTO) {
		BookingDTO updatedBookingDTO = paymentService.processPayment(bookingDTO);
		return updatedBookingDTO;
	}

}

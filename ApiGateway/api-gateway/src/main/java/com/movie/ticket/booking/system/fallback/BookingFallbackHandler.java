package com.movie.ticket.booking.system.fallback;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingFallbackHandler {

	@GetMapping("/booking-fallback")
	public String bookingFallback() {
		return " Booking service is under the maintenance please try after sometime ";
	}
}


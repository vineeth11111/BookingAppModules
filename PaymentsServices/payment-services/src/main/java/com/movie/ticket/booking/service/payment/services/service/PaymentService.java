package com.movie.ticket.booking.service.payment.services.service;

import com.movie.ticket.booking.service.payment.services.dto.BookingDTO;

public interface PaymentService {

	public BookingDTO processPayment(BookingDTO BookingDTO);
}

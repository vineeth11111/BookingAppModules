package com.movie.ticket.booking.service.payment.services.service.stripe;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.movie.ticket.booking.service.payment.services.dto.BookingDTO;
import com.movie.ticket.booking.service.payment.services.dto.BookingStatus;
import com.stripe.Stripe;
import com.stripe.model.Charge;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StripeApiPaymentGateway {

	@Value("${stripe.key}")
	private String stripeKey;
	
	@PostConstruct
	public void init() {
		Stripe.apiKey = stripeKey;
	}
	//Used to pay using payment API Gateway(stripe)
	public BookingDTO processPayment(BookingDTO bookingDTO) {
		Map<String, Object> paymentDetails = new HashMap<>();
		paymentDetails.put("amount", (int)(Math.round(bookingDTO.getBookingAmount()) * 100 ) );
		paymentDetails.put("currency", "inr");
		paymentDetails.put("description", "payment successfully" );
		paymentDetails.put("source", "tok_visa");//tok_amex
		try {
			Charge.create(paymentDetails);
			bookingDTO.setBookingStatus(BookingStatus.SUCCESS);
		}
		catch(Exception e) {
			bookingDTO.setBookingStatus(BookingStatus.CANCELLED);
			log.error(e.getMessage());
		}
		
		return bookingDTO;
		
	}
}

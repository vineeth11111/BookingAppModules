package com.movie.ticket.booking.service.payment.services.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.ticket.booking.service.payment.services.dto.BookingDTO;
import com.movie.ticket.booking.service.payment.services.entity.PaymentEntity;
import com.movie.ticket.booking.service.payment.services.enums.PaymentStatus;
import com.movie.ticket.booking.service.payment.services.repo.PaymentRepository;
import com.movie.ticket.booking.service.payment.services.service.stripe.StripeApiPaymentGateway;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
	
	private @Autowired PaymentRepository paymentRepository;
	private @Autowired StripeApiPaymentGateway stripeApiPaymentGateway;

	@Override
	public BookingDTO processPayment(BookingDTO bookingDTO) {
		//started payment processing
		BookingDTO bookingDTOAfterPayment = stripeApiPaymentGateway.processPayment(bookingDTO);
		PaymentEntity paymentEntity = PaymentEntity.builder().bookingId(bookingDTOAfterPayment.getBookingId())
		                       .paymentStatus(PaymentStatus.SUCCESS)
		                       .paymentAmount(bookingDTOAfterPayment.getBookingAmount())
		                       .paymentDateTime(LocalDateTime.now())
		                       .build();
		paymentRepository.save(paymentEntity);
		return bookingDTOAfterPayment;
	}

}

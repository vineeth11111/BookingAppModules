package com.movie.ticket.booking.service.payment.services.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.ticket.booking.service.payment.services.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {

}

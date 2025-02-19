package  com.movie.ticket.booking.service.payment.services.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.movie.ticket.booking.service.payment.services.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID paymentId;
	private UUID bookingId;
	//@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	private Double paymentAmount;
	private LocalDateTime paymentDateTime;
}

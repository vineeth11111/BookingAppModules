package com.luv2code.OneToOneMultiplicity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AadharCard {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID aadharId;
	
	private String aadharAddress;
}

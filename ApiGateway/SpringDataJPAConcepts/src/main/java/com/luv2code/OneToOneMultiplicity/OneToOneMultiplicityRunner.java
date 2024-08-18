package com.luv2code.OneToOneMultiplicity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class OneToOneMultiplicityRunner implements CommandLineRunner {
	
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private AadharCardRepository aadharCardRepo;

	@Override
	public void run(String... args) throws Exception {
		
		AadharCard aadharCard= new AadharCard();
		aadharCard.setAadharAddress("aadharCard address ");
		
		Person person = new Person();
		person.setName("abcd");
		person.setAddress(" person address");
		person.setAadharCard(aadharCard);
		
		aadharCardRepo.save(aadharCard);
		personRepo.save(person);
	}

}

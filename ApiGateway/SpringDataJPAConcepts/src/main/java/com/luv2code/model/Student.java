package com.luv2code.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NonNull
	private String name;
	@NonNull
	private Double fee;
	
	@ElementCollection
	@OrderColumn
	@CollectionTable(name = "Student_Addresses" , joinColumns =  @JoinColumn(name="id"))
	private List<String> address;
	
	@ElementCollection 
	@CollectionTable(name = "Student_subjects" , joinColumns =  @JoinColumn(name="id"))
	private Set<String> subjects;
	
	@ElementCollection
	@MapKeyColumn
	@CollectionTable(name = "Student_report" , joinColumns =  @JoinColumn(name="id"))
	private Map<String , Double> report;
}

package com.luv2code.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luv2code.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	 @Query("SELECT id , name , department FROM Employee WHERE salary >= :sal")
	 List<Object[]> getAllIdNameDept(Double sal);
}

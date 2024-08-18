package com.luv2code.runners;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.luv2code.model.Employee;
import com.luv2code.model.Student;
import com.luv2code.repo.EmployeeRepository;
import com.luv2code.repo.StudentRepository;

//@Component
public class EmployeeDataInsertRunner implements CommandLineRunner {
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public void run(String... args) throws Exception {
		Employee emp1 = new Employee(100 ,"kohli", "python", 8000.0,new Date(),new Date(),new Date());
		Employee emp2 = new Employee("rohit", "AI", 8000.0);
		Employee emp3 = new Employee("sky", "AI", 4000.0);
		Employee emp4 = new Employee("bhuvi", "ML", 4000.0);
		Employee emp5 = new Employee("virat", "AI", 8000.0);
		Employee emp6 = new Employee("david", "java", 6000.0);
		Employee emp7 = new Employee("warner", "C#", 6000.0);
		Employee emp8 = new Employee("roy", "cobalt", 3000.0);
		Employee emp9 = new Employee("rohit", "python", 7000.0);
		Employee emp10 = new Employee("hardik", "c++", 6000.0);
		
		employeeRepo.saveAll(Arrays.asList(emp1 , emp2 , emp3 , emp4 , emp5 , emp6 , emp7 , emp8 , emp9 , emp10));
		
		/*                                TOPIC : #1
		 * Sort is a class used to arrange element based on given order.
		 * We have to make use of a static method called "by(... var-args)" where var-args are properties of a class.
		 * Here we sorted our Employees based on name and salary separately.
		 * When we use both name and salary first it sorts using name and then if it finds "n" objects having same rank then it sorts based on salary.
		 */
         
	/*	Sort sortByName = Sort.by("name");
		List<Employee> sortedEmployeesByNames = employeeRepo.findAll(sortByName);
		System.out.println("=============     sortedEmployeesByNames START ============================");
		sortedEmployeesByNames.forEach(System.out::println);
		System.out.println("=============     sortedEmployeesByNames END ============================");
		
		
		Sort sortBySalary = Sort.by(Direction.DESC , "salary");
		List<Employee> sortedEmployeesBySalary = employeeRepo.findAll(sortBySalary);
		System.out.println("=============     sortedEmployeesBySalary START ============================");
		sortedEmployeesBySalary.forEach(System.out::println);
		System.out.println("=============     sortedEmployeesBySalary END ============================");
    
		
		 Sort sortBySalaryAndNames = Sort.by(Direction.DESC , "name","salary" );
		List<Employee> sortedEmployeesBySalaryAndNames = employeeRepo.findAll(sortBySalaryAndNames);
		System.out.println("=============     sortedEmployeesBySalaryAndNames START ============================");
		sortedEmployeesBySalaryAndNames.forEach(System.out::println);
		System.out.println("=============     sortedEmployeesBySalaryAndNames END ============================");
		
		*/
		
		/*
		 *                       Topic #2
		 *     Example is an interface. Help us to get required objects based on object given to it.
		 *     Here "of" is a static method. Where we have to provide object to it.                  
		 */
		
		/*  Employee employee = new Employee();
		  employee.setSalary(8000.0);
		  Example<Employee> employeeExample = Example.of(employee);
		  List<Employee> requiredEmployees = employeeRepo.findAll(employeeExample);
		  requiredEmployees.forEach(System.out::println);
		  */
	  
		  
		  /*
		   *                 Topic #3
		   *   To implement Pagination we have to provide inputs to the Pageable(I)
		   *   PageRequest(class) Implementation of Pageable(I)
		   *   PageRequest(pageNumber , PageSize) OR PageRequest(pageNumber , PageSize , Sort)
		   */
		  /*
		  Pageable pageable = PageRequest.of(0, 3);
		  Page<Employee> empPage = employeeRepo.findAll(pageable);
		  List<Employee> employees = empPage.getContent();
		  employees.forEach(System.out::println);
		  */
		
		/*
		 *                  Topic #4
		 *         Projections(getting only required data) using @Query         
		 */
		
	/*	List<Object[]> allIdNameDept = employeeRepo.getAllIdNameDept(3000.0);
		
		for(Object[] empData : allIdNameDept) {
			System.out.println(empData[0] + " , "+empData[1] +" , "+empData[2 ]);
		}*/
		
		
		/*
		 *                     Topic #5
		 *        Saving Collection Data             
		 */
		
		Student student = new Student();
		student.setName("abcd");
		student.setFee(30000.0);
		student.setAddress(Arrays.asList("addr1" , "addr2"));
		student.setSubjects(new HashSet<>(Arrays.asList("science" , "maths")));
		Map<String , Double> reports = new HashMap<>();
		reports.put("science", 78.0);
		reports.put("maths", 98.0);
		student.setReport(reports);
		 
		studentRepo.save(student);
		
		Student student2 = new Student();
		student2.setName("efgh");
		student2.setFee(40000.0);
		student2.setAddress(Arrays.asList("addr3" , "addr4"));
		student2.setSubjects(new HashSet<>(Arrays.asList("physics" , "maths 2")));
		Map<String , Double> reports2 = new HashMap<>();
		reports2.put("physics", 88.0);
		reports2.put("maths 2", 88.2);
		student2.setReport(reports2);
		
		studentRepo.save(student2);
	}

}

package com.olive.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.olive.model.Deparment;
import com.olive.model.Employee;
import com.olive.repo.DeptRepositiory;
import com.olive.repo.EmployeeRepositiory;

//@Component
public class DataInsertRunner implements CommandLineRunner {
	@Autowired
	private DeptRepositiory drepo;

	@Autowired
	private EmployeeRepositiory erepo;

	public void run(String... args) throws Exception {
		Deparment d1 = new Deparment(10, "DEV", "Sanjay");
		Deparment d2 = new Deparment(20, "QA", "Ravi Raj");
		drepo.save(d1);
		drepo.save(d2);
		erepo.save(new Employee(101, "Ravi Kumar", 10.2, "Hyd", d1));
		erepo.save(new Employee(102, "Mohan Kumar", 5.0, "Hyd", d1));
		erepo.save(new Employee(103, "Rohan Kumar", 10.0, "Hyd", d1));
		erepo.save(new Employee(104, "Karan Kumar", 20.2, "Hyd", d2));
		erepo.save(new Employee(105, "Sunil Kumar", 50.20, "Hyd", d2));
		erepo.save(new Employee(106, "Komal Kumar", 300.20, "Hyds", null));
		erepo.save(new Employee(107, "Rashmi ", 100.20, "Hyds", null));

		System.out.println("Data Inserted");

	}

}

package com.olive.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.olive.model.Deparment;
import com.olive.model.Employee;
import com.olive.repo.DeptRepositiory;
import com.olive.repo.EmployeeRepositiory;

@Component
public class TestDataRunner implements CommandLineRunner {
	@Autowired
	private DeptRepositiory drepo;

	@Autowired
	private EmployeeRepositiory erepo;

	public void run(String... args) throws Exception {

		List<Object[]> list = erepo.getEmpAndDeptInnerJoinData();
		for (Object[] ob : list) {
			System.out.println("Emp Name  :" + ob[0]);
			System.out.println("Department : " + ob[1]);
		}
		/*
		 * Using Name Param concept
		 */

		System.out.println("******************************");
		List<Object[]> list2 = erepo.getEmpAndDeptLeftJoinData2(20.2);
		for (Object[] ob1 : list2) {
			System.out.println("Emp Name  :" + ob1[0]);
			System.out.println("Department : " + ob1[1]);
		}

		System.out.println("********Getting Only Parent table Data******* ");
		List<Object[]> l1 = erepo.getPareentSideDataUsingLeftJoin();
		for (Object[] ob2 : l1) {
			System.out.println("ID :: " + ob2[0]);

		}
		System.out.println("##############################");
		List<Employee> emp = erepo.getPareentSideRecordUsingLeftJoin();
		emp.forEach(System.out::println);

	}
}

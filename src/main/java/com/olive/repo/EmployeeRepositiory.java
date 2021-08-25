package com.olive.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.olive.model.Employee;

public interface EmployeeRepositiory extends JpaRepository<Employee, Integer> {

	@Query("select e.empName,d.deptCode from Employee e INNER JOIN e.dept as d")
	List<Object[]> getEmpAndDeptInnerJoinData();

	// ***********Getting Right table row data and Left table connected row data

	@Query("select e.empName,d.deptCode from Employee e RIGHT JOIN e.dept as d")
	List<Object[]> getEmpAndDeptRightJoinData();

	// ***********Getting Left table data and Right table connected row data

	@Query("select e.empName,d.deptCode from Employee e LEFT JOIN e.dept as d where e.empSal>=:sal")
	List<Object[]> getEmpAndDeptLeftJoinData2(double sal);

	// *********************Getting Only Parent table row Data*****************

	@Query("select e.empId from Employee e LEFT JOIN e.dept d where d IS NULL")
	List<Object[]> getPareentSideDataUsingLeftJoin();

	@Query("select e from Employee e LEFT JOIN e.dept d where d IS NULL")
	List<Employee> getPareentSideRecordUsingLeftJoin();
}

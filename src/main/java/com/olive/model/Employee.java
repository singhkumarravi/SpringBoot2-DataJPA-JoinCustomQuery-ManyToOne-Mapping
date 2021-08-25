package com.olive.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Table(name = "Employees_tab")
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	private Integer empId;
	private String empName;
	private double empSal;
	private String addr;
	@ManyToOne
	@JoinColumn(name = "did_FK")
	private Deparment dept;
}

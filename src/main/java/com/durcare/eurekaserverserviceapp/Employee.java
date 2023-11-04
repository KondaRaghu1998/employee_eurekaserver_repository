package com.durcare.eurekaserverserviceapp;

import java.time.LocalDate;

public class Employee {
	private int id;
	private String name;
	private String gender;
	private String department;
	private LocalDate doj;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String gender, String department, LocalDate doj) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.doj = doj;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public LocalDate getDoj() {
		return doj;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department + ", doj="
				+ doj + "]";
	}

}

package com.denizturkmen.Entity;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="Employee_Table")
@DynamicUpdate
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Employee_id")
	private Integer employeeId;
	
	@Column(name = "Employee_name",length = 100,nullable = false)
	private String EmployeeName;
	
	@Column(name = "Email",unique = false)
	private String Email;
	
	@Column(name = "Date_of_Joining")
	private Date doj;
	
	@Column(name="Salary")
	private Double Salary;

	//ANA classımız EMPLOYEE
	@OneToOne(cascade = CascadeType.PERSIST)
	//Foreign kEy alanı kendimiz isimlendiriyoruz
	@JoinColumn(name = "Adress_ID")
	private Adress adress;
	
	
		public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", EmployeeName=" + EmployeeName + ", Email=" + Email + ", doj="
				+ doj + ", Salary=" + Salary + ", adress=" + adress + "]";
	}

	
	
	
	
	
}

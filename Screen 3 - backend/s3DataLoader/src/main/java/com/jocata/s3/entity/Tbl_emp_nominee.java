package com.jocata.s3.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "tbl_emp_nominee")
public class Tbl_emp_nominee implements Serializable{
	
	private static final long serialVersionUID = -2121131567286956697L;
	
	private int id;
	private String nominee_full_name;
	private String nominee_full_address;
	private String nominee_relationship;
	private int nominee_age;
	private int share_payable;
	private String nominee_occupation;
	private String date_of_nomination;
	private String witness1;
	private String witness2;
	private String saved_date;
	private int emp_id;
	
	@ManyToOne
	private Tbl_employee_master emp;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNominee_full_name() {
		return nominee_full_name;
	}
	public void setNominee_full_name(String nominee_full_name) {
		this.nominee_full_name = nominee_full_name;
	}
	public String getNominee_full_address() {
		return nominee_full_address;
	}
	public void setNominee_full_address(String nominee_full_address) {
		this.nominee_full_address = nominee_full_address;
	}
	public String getNominee_relationship() {
		return nominee_relationship;
	}
	public void setNominee_relationship(String nominee_relationship) {
		this.nominee_relationship = nominee_relationship;
	}
	public int getNomineeAge() {
		return nominee_age;
	}
	public void setNomineeAge(int age) {
		this.nominee_age = age;
	}
	public int getShare_payable() {
		return share_payable;
	}
	public void setShare_payable(int share_payable) {
		this.share_payable = share_payable;
	}
	public String getNominee_occupation() {
		return nominee_occupation;
	}
	public void setNominee_occupation(String nominee_occupation) {
		this.nominee_occupation = nominee_occupation;
	}
	public String getDate_of_nomination() {
		return date_of_nomination;
	}
	public void setDate_of_nomination(String date_of_nomination) {
		this.date_of_nomination = date_of_nomination;
	}
	public String getWitness1() {
		return witness1;
	}
	public void setWitness1(String witness1) {
		this.witness1 = witness1;
	}
	public String getWitness2() {
		return witness2;
	}
	public void setWitness2(String witness2) {
		this.witness2 = witness2;
	}
	public String getSaved_date() {
		return saved_date;
	}
	public void setSaved_date(String saved_date) {
		this.saved_date = saved_date;
	}
	

	@JoinColumn(name = "id")
	public int getEmp_id() {
		return emp_id;
	}
	
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
}

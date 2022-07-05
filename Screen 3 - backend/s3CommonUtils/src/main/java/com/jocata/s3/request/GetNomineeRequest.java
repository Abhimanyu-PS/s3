package com.jocata.s3.request;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonIgnoreProperties
public class GetNomineeRequest implements Serializable{
	
	private static final long serialVersionUID = 6044979992638529931L;
	@JsonProperty("empId")
	private int empId;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
}

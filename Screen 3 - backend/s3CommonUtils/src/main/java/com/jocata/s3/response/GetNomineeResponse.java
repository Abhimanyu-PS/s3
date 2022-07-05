package com.jocata.s3.response;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jocata.s3.nominee.NomineeResponse;

@Component
@JsonIgnoreProperties
public class GetNomineeResponse implements Serializable{

	private static final long serialVersionUID = 2248871839566565186L;
	@JsonProperty("empId")
	private int empId;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("nominees")
	private ArrayList<NomineeResponse> nominees;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public ArrayList<NomineeResponse> getNominees() {
		return nominees;
	}
	public void setNominees(ArrayList<NomineeResponse> nominees) {
		this.nominees = nominees;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}

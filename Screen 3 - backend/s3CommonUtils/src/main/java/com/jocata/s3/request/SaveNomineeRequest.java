package com.jocata.s3.request;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jocata.s3.nominee.NomineeRequest;

@Component
@JsonIgnoreProperties
public class SaveNomineeRequest implements Serializable{

	private static final long serialVersionUID = -7445966020105558856L;
	@JsonProperty("empId")
	private int empId;
	
	@JsonProperty("nominees")
	private ArrayList<NomineeRequest> nominees;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public ArrayList<NomineeRequest> getNominees() {
		return nominees;
	}
	public void setNominees(ArrayList<NomineeRequest> nominees) {
		this.nominees = nominees;
	}
	
}

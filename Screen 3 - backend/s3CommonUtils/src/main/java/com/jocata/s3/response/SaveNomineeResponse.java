package com.jocata.s3.response;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonIgnoreProperties
public class SaveNomineeResponse implements Serializable{

	private static final long serialVersionUID = 4296021833395316325L;
	@JsonProperty("empId")
	private int empId;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("stage")
	private String stage;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	
}

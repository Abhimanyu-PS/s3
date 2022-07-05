package com.jocata.s3.nominee;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonIgnoreProperties
public class NomineeResponse implements Serializable{
	
	private static final long serialVersionUID = 6575451155081150190L;

	@JsonProperty("nomineeFullName")
	private String nominee_full_name;
	
	@JsonProperty("nomineeFullAddress")
	private String nominee_full_address;
	
	@JsonProperty("nomineeRelationship")
	private String nominee_relationship;
	
	@JsonProperty("nomineeAge")
	private int nominee_age;
	
	@JsonProperty("sharePayable")
	private String share_payable;
	
	@JsonProperty("nomineeOccupation")
	private String nominee_occupation;
	
	@JsonProperty("witness1")
	private String witness1;
	
	@JsonProperty("witness2")
	private String witness2;

	
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

	public int getNominee_age() {
		return nominee_age;
	}

	public void setNominee_age(int nominee_age) {
		this.nominee_age = nominee_age;
	}

	public String getShare_payable() {
		return share_payable;
	}

	public void setShare_payable(String share_payable) {
		this.share_payable = share_payable;
	}

	public String getNominee_occupation() {
		return nominee_occupation;
	}

	public void setNominee_occupation(String nominee_occupation) {
		this.nominee_occupation = nominee_occupation;
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
	
}


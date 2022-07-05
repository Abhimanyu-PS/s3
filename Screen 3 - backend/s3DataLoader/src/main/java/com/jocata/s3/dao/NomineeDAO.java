package com.jocata.s3.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jocata.s3.entity.Tbl_emp_nominee;
import com.jocata.s3.entity.Tbl_employee_master;
import com.jocata.s3.response.GetNomineeResponse;

@Component
public interface NomineeDAO {
	public String saveNomineeDetails(List<Tbl_emp_nominee> nominees);
	public GetNomineeResponse getNomineeDetails(Tbl_employee_master employee);
}

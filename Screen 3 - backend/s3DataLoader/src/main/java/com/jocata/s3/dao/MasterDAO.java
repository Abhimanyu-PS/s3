package com.jocata.s3.dao;

import org.springframework.stereotype.Component;

import com.jocata.s3.entity.Tbl_employee_master;

@Component
public interface MasterDAO {
	public void updateStage(Tbl_employee_master emp);
}
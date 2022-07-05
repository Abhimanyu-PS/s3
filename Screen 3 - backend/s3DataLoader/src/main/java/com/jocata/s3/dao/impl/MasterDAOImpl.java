package com.jocata.s3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jocata.s3.dao.MasterDAO;
import com.jocata.s3.daoutils.HibernateUtils;
import com.jocata.s3.entity.Tbl_employee_master;

@Repository
public class MasterDAOImpl implements MasterDAO{

	@Autowired
	HibernateUtils hibernateUtils;
	
	@Override
	public void updateStage(Tbl_employee_master emp) {
		emp.setStage("Screen 3");
		hibernateUtils.update(emp);
	}
}

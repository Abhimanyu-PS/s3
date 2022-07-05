package com.jocata.s3.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jocata.s3.dao.NomineeDAO;
import com.jocata.s3.daoutils.HibernateUtils;
import com.jocata.s3.entity.Tbl_emp_nominee;
import com.jocata.s3.entity.Tbl_employee_master;
import com.jocata.s3.nominee.NomineeResponse;
import com.jocata.s3.response.GetNomineeResponse;

@Repository
public class NomineeDAOImpl implements NomineeDAO{

	
	@Autowired
	HibernateUtils hibernateUtils;

	@Override
	public String saveNomineeDetails(List<Tbl_emp_nominee> nominee) {
		ArrayList<Tbl_emp_nominee> ls = (ArrayList<Tbl_emp_nominee>) nominee;
		try {
			for(Tbl_emp_nominee req : ls) {
				hibernateUtils.save((Object)req);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		return "success";
	}

	@Override
	public GetNomineeResponse getNomineeDetails(Tbl_employee_master emp1) {
		Integer id = (Integer) emp1.getId();
		Tbl_employee_master emp = new Tbl_employee_master();
		emp = (Tbl_employee_master) hibernateUtils.findEntityById(emp, id);
		List<NomineeResponse> list =  hibernateUtils.loadEntityByHql("from Tbl_emp_nominee n where n.emp_id ="+id);
		
		GetNomineeResponse res = new GetNomineeResponse();
		res.setEmpId(id);
		res.setNominees((ArrayList<NomineeResponse>)list);
		res.setStatus("success");
		
		return res;
	}

}

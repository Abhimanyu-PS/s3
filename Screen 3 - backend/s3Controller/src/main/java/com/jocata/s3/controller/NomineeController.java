package com.jocata.s3.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.s3.dao.MasterDAO;
import com.jocata.s3.dao.NomineeDAO;
import com.jocata.s3.daoutils.HibernateUtils;
import com.jocata.s3.entity.Tbl_emp_nominee;
import com.jocata.s3.entity.Tbl_employee_master;
import com.jocata.s3.nominee.NomineeRequest;
import com.jocata.s3.request.GetNomineeRequest;
import com.jocata.s3.request.SaveNomineeRequest;
import com.jocata.s3.response.GetNomineeResponse;
import com.jocata.s3.response.SaveNomineeResponse;

@RestController
@CrossOrigin
@RequestMapping("/nominee")
public class NomineeController {
	
	@Autowired
	NomineeDAO nomineeDAO;
	
	@Autowired
	HibernateUtils hibernateUtils;
	
	@Autowired
	MasterDAO masterDAO;
	
	@PostMapping("/saveNomineeDetails")
	public ResponseEntity<?> saveNomineeDetails(@RequestBody SaveNomineeRequest snr){
		
		ArrayList<Tbl_emp_nominee> list = new ArrayList<>();
		ArrayList<NomineeRequest> reqNom = snr.getNominees();
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateString = formatter.format(date);
		
		for(NomineeRequest req : reqNom) {
			Tbl_emp_nominee nominee = new Tbl_emp_nominee();
			
			nominee.setNomineeAge(req.getNominee_age());
			nominee.setDate_of_nomination(dateString);
			nominee.setEmp_id(snr.getEmpId());
			nominee.setNominee_full_address(req.getNominee_full_address());
			nominee.setNominee_full_name(req.getNominee_full_name());
			nominee.setNominee_occupation(req.getNominee_occupation());
			nominee.setNominee_relationship(req.getNominee_relationship());
			nominee.setSaved_date(dateString);
			nominee.setShare_payable(Integer.parseInt(req.getShare_payable().split("%")[0]));
			nominee.setWitness1(req.getWitness1());
			nominee.setWitness2(req.getWitness2());
			
			list.add(nominee);
		}
		nomineeDAO.saveNomineeDetails(list);
		Tbl_employee_master emp = new Tbl_employee_master();
		
		emp = hibernateUtils.findEntityById(emp, snr.getEmpId());
		masterDAO.updateStage(emp);
		SaveNomineeResponse snre = new SaveNomineeResponse();
		snre.setEmpId(snr.getEmpId());
		snre.setStage(emp.getStage());
		snre.setStatus("success");
		
		return new ResponseEntity<SaveNomineeResponse>(snre,HttpStatus.CREATED); 
	}
	
	@GetMapping("/getNomineeDetails")
	public ResponseEntity<?> getNomineeDetails(@RequestBody GetNomineeRequest snr){
		
		Tbl_employee_master emp = new Tbl_employee_master();
		emp.setId(snr.getEmpId());
		GetNomineeResponse res = nomineeDAO.getNomineeDetails(emp);
		
		return new ResponseEntity<GetNomineeResponse>(res,HttpStatus.CREATED); 
	}
}

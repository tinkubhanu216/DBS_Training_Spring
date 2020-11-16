package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.InsuranceDao;
import com.example.model.Insurance;


@RestController
public class MainController {
	@Autowired
	InsuranceDao incDao;
	
	@RequestMapping(value="/insurance/add",method=RequestMethod.POST)
	public String addController(@RequestBody Insurance inc) {
		incDao.addRecord(inc);
        return "Created";    
	}
	@RequestMapping(value="/insurance/delete/{policyno}",method=RequestMethod.GET)
	public String deleteController(@PathVariable("policyno") int policyno) {
		incDao.deleteRecord(policyno);
        return "Deleted";
	}
	@RequestMapping(value="/insurance/update",method=RequestMethod.GET)
	public String updateController(@RequestParam("policyno") int policyno,@RequestParam("amount") int amount) {
		incDao.updatePolicy(policyno, amount);
        return "Updated";    
	}
	@RequestMapping(value="/insurance/display/{policyno}",method=RequestMethod.GET)
	public Insurance disController(@PathVariable("policyno") int policyno) {
		return incDao.display(policyno);    
	}
	@RequestMapping(value="/insurance/displayAll",method=RequestMethod.GET)
	public List<Insurance> disController() {
		return incDao.displayAll();    
	}
}

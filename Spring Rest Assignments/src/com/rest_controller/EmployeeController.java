package com.rest_controller;
import com.rest_model.Employee;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payroll")
public class EmployeeController {
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String getEmployee(@PathVariable int id) {
		
		HashMap<Integer,Employee> hml=new HashMap<Integer,Employee>();
		
		hml.put(1, new Employee(1,"bhanu",55000,3500,2000,200));
		hml.put(1, new Employee(2,"raj",50000,3500,2000,200));
		hml.put(1, new Employee(3,"tarun",45000,3500,2000,200));
		
		Employee emp=null;
		if(hml.containsKey(id)) {
			emp=hml.get(id);
		}
		emp.setGrossSal(emp.getBasic()+emp.getHra()+emp.getAllowance());
		emp.setFinalDeductions((int) (emp.getDeductions()+(emp.getGrossSal()*0.2)));
		emp.setTotalSal(emp.getGrossSal()-emp.getFinalDeductions());
		
		return emp.toString();
	}
	@RequestMapping(value="/display",method=RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody String name){
		System.out.println(name);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
}

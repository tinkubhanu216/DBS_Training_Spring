package com.example.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Insurance;
import com.example.repository.InsuranceRepository;


@Service
public class InsuranceDao {
	
	@Autowired
	InsuranceRepository incRepository;
	
	public void addRecord(Insurance inc) {
		incRepository.save(inc);
	}
	public void deleteRecord(int policyno) {
		incRepository.deleteById(policyno);
	}
	
	public void updatePolicy(int policyno,int amount) {
		Insurance inc=incRepository.findById(policyno);
		inc.setAmount(amount);
		incRepository.save(inc);
		
	}
	public  Insurance display(int policyid) {
		return incRepository.findById(policyid);
	}
	
	public List<Insurance> displayAll() {
		List<Insurance> policyList=(List<Insurance>) incRepository.findAll();
		return policyList;
	}
}

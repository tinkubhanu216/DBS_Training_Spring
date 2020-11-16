package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Insurance;

public interface InsuranceRepository extends CrudRepository<Insurance,Integer> {
	Insurance findById(int policyno);
}

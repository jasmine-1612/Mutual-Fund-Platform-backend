package com.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.Investor;

public interface InvestorRepository extends CrudRepository<Investor, Integer> {
	Investor findByEmail(String email);

}
 
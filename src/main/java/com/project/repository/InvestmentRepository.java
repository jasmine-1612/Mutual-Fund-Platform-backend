package com.project.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.project.Investment;

public interface InvestmentRepository extends CrudRepository<Investment, Number>  {
	ArrayList<Investment>  findInvestmentsByInvestorId(int id);
	Investment findInvestmentByInvestmentId(int id);
	ArrayList<Investment> findByInvestorIdAndFundId(int investorId, int fundId);
	ArrayList<Investment> findByInvestorId(Integer investorId);
}

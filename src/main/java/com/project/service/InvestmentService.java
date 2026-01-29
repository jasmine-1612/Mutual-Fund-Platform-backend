package com.project.service;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Investment;
import com.project.repository.InvestmentRepository;


@Service
public class InvestmentService {

	@Autowired
	InvestmentRepository ivRepository;
	
	public ArrayList<Investment> getAllInvestments(){
		return (ArrayList<Investment>) ivRepository.findAll();
	}
	
	public String addAInvestment(Investment newInvestment) {
		ivRepository.save(newInvestment);
		return "Successfully added a new investment!";
	}

	public Investment getInvestmentDetails(int investmentId) {
		
//		for(Investment i : ivRepository.findAll()) {
//			if(i.getInvestmentId()==investmentId)
//				return i;
//		}
//		
//		return null;
		
		return ivRepository.findInvestmentByInvestmentId(investmentId);
	}
	
	public ArrayList<Investment> getInvestmentsById(int investorid) {

		ArrayList<Investment> allInvestmentsforInvestor = new ArrayList<Investment>();
		
		 for(Investment investment : ivRepository.findAll()) {
			 if(investment.getInvestorId()==investorid) {
				 allInvestmentsforInvestor.add(investment);
			 }
		 }
		 System.out.println(allInvestmentsforInvestor);
		 return allInvestmentsforInvestor;

		
	}
	
	public ArrayList<Investment> getAllInvestmentsByInvestorForAFund(int investorId, int fundId){
		
		return ivRepository.findByInvestorIdAndFundId(investorId, fundId);
	}

	
//	returns the total unit for a mf
	public double getTotalUnitsForInvestorForAFund(int investorId, int fundId){
		
		ArrayList<Investment> investments=getAllInvestmentsByInvestorForAFund(investorId, fundId);
//		System.out.println(investments);
		double totalUnits=0;
		for(Investment investment: investments) {
			totalUnits+=investment.getUnits();
		}
		
		return totalUnits;
		
	}
	

//return all unique mutual fund invested in	
	 public Set<Integer> getDistinctFundIdsByInvestorId(Integer investorId) {
	        ArrayList<Investment> investments = ivRepository.findByInvestorId(investorId);
	        return investments.stream()
	                          .map(Investment::getFundId)
	                          .collect(Collectors.toSet());
	    }
	
}

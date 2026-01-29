package com.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.MutualFund;
import com.project.PortfolioManager;
import com.project.repository.MutualFundRepository;
import com.project.repository.PortfolioManagerRepository;

@Service
public class PortfolioManagerService {

	@Autowired
	PortfolioManagerRepository pmRepository;
	@Autowired
	MutualFundRepository mfRepository;
	
	public String addPortfolioManager(PortfolioManager pm) {
		
		pmRepository.save(pm);
		return "Successfully inserted";
	}
	
	public ArrayList<PortfolioManager> getAllPortfolioManagers(){
		
		System.out.println("inside the service");
		return (ArrayList<PortfolioManager>) pmRepository.findAll();
	}

	public ArrayList<MutualFund> getAllMutualFunds(int managerId) {
		
		ArrayList<MutualFund> allMutualFundsByManager = new ArrayList<MutualFund>();
			
			for(MutualFund mf : mfRepository.findAll()) {
				if(mf.getManagerId()==managerId) {
					allMutualFundsByManager.add(mf);
				}
			}
			return allMutualFundsByManager;
		
	}	
	
}

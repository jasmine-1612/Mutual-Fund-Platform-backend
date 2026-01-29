package com.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.MutualFund;
import com.project.PortfolioManager;
import com.project.service.PortfolioManagerService;

@RestController
public class PortfolioManagerController {

	@Autowired
	PortfolioManagerService pm;
	
	@RequestMapping(value="/portfoliomanagers", method=RequestMethod.GET)
	public ArrayList<PortfolioManager> getAllPortfolioManagers(){
		
		System.out.println("inside the controller");
		return pm.getAllPortfolioManagers();
	}
	
	@RequestMapping(value="/portfoliomanagers/add", method=RequestMethod.POST)
	public String addPortfolioManager(@RequestBody PortfolioManager newPortfolioManager ){
	
		System.out.println("inside the controller");
		return pm.addPortfolioManager(newPortfolioManager); 
	}
	
	@RequestMapping(value="/portfoliomanagers/getAllMF/{managerId}", method=RequestMethod.GET)
	public ArrayList<MutualFund> getAllMutualFunds(@PathVariable int managerId){
		return pm.getAllMutualFunds(managerId);
	}
	
	

}

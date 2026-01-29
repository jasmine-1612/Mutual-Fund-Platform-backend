package com.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Investor;
import com.project.service.InvestorService;

@RestController
public class InvestorController {

	@Autowired
	InvestorService is;
	
	

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> requestMap) {
        // Basic input validation
		 String email = requestMap.get("email");
	        String password = requestMap.get("password");
        if (email == null || password == null) {
            return ResponseEntity.badRequest().body("email and password are required.");
        }
        // Call the authentication logic in your service
        Investor investor = is.authenticate(email, password);

        if (investor !=null) {
        	Map<String, Object> response = new HashMap<String, Object>();
        	
        	response.put("status", "success");
        	response.put("message", "Login successful");
        	response.put("investorid", investor.getId());
        	
//        	System.out.println(response.get("investorid"));
        	System.out.println(response.getClass());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
	
	
	
	
	@RequestMapping(value="/investors", method=RequestMethod.GET)
	public ArrayList<Investor> getAllInvestors(){
		
		return is.getAllInvestors();
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String addInvestor(@RequestBody Investor newInvestor ){
		return is.addInvestor(newInvestor); 	
	}
	
	
	@RequestMapping(value="/investors/id/{investorid}", method=RequestMethod.GET)
	public Investor getInvestorInfor(@PathVariable int investorid){
		return is.getInvestorInfo(investorid);
	}
	
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Investor investor) {
		System.out.println(investor.getFirstName());
		System.out.println(investor.getLastName());
		System.out.println(investor.getEmail());
		System.out.println(investor.getContactNumber());
		System.out.println(investor.getPassword());
		if (investor.getFirstName() == null || investor.getLastName() == null ||
	            investor.getEmail() == null || investor.getContactNumber() == null || investor.getPassword() == null) {
	        return ResponseEntity.badRequest().body("All fields are required.");
	    }

        // Check if email already exists
        if (is.emailExists(investor.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists.");
        }

        // Create a new Investor object and save it
        is.addInvestor(investor);

        return ResponseEntity.ok("Registration successful");
    }

	
}

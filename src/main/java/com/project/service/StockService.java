package com.project.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.Stock;
import com.project.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository sRepository;

	public ArrayList<Stock> getAllStocks(){

		return (ArrayList<Stock>) sRepository.findAll();
	}

	
	public String addStocks(@RequestBody Stock newStock ){

		 sRepository.save(newStock);		 
		 return "Successfully added a new stock!";
	}
	
	
	public Stock getStockInfo(@PathVariable int stockId) {
		
		return sRepository.findOne(stockId);
	}


//	public ArrayList<Stock> getStockInfoByDate(String date) {
//		// TODO Auto-generated method stub
//		return sRepository.findByDateOfRecord(date);
//	}

	
	public ArrayList<Stock> getAllStocksBy1(){

		return (ArrayList<Stock>) sRepository.findStocksByCustomQuery();
	}
}

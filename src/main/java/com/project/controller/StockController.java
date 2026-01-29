//package com.project.controller;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.project.Stock;
//import com.project.service.StockService;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class StockController {
//
//	@Autowired
//	StockService ss;
//	
//	
//	@RequestMapping(value="/stocks", method=RequestMethod.GET)
//	public ArrayList<Stock> getAllStocks(){
//		
//		return ss.getAllStocks();
//	}
//	
//	@RequestMapping(value="/stocks/add", method=RequestMethod.POST)
//	public String addStocks(@RequestBody Stock newStock ){
//	
//		return ss.addStocks(newStock); 
//	}
//	
//	@RequestMapping(value="stocks/id/{stockId}", method=RequestMethod.GET)
//	public Stock getStockInfo(@PathVariable int stockId) {
//		
//		return ss.getStockInfo(stockId);
//	}
//	
//	@RequestMapping(value="stocks/date/{date}", method=RequestMethod.GET)
//	public ArrayList<Stock> getStockbyDate(@PathVariable String date) {
//		
//		return ss.getStockInfoByDate(date);
//	}
//}



package com.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Stock;
import com.project.service.StockService;

@RestController
public class StockController {

	@Autowired
	StockService ss;
	
	
	@RequestMapping(value="/stocks", method=RequestMethod.GET)
	public ArrayList<Stock> getAllStocks(){
		
		return ss.getAllStocks();
	}
	
	@RequestMapping(value="/stocks/byid", method=RequestMethod.GET)
	public ArrayList<Stock> getAllStocksBy1(){
		
		return ss.getAllStocksBy1();
	}
	
	@RequestMapping(value="/stocks/add", method=RequestMethod.POST)
	public String addStocks(@RequestBody Stock newStock ){
	
		return ss.addStocks(newStock); 
	}
	
	@RequestMapping(value="stocks/id/{stockId}", method=RequestMethod.GET)
	public Stock getStockInfo(@PathVariable int stockId) {
		
		return ss.getStockInfo(stockId);
	}
	
}


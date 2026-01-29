//package com.project.service;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.MutualFund;
//import com.project.Stock;
//import com.project.StockInfo;
//import com.project.StocksInFund;
//import com.project.repository.MutualFundRepository;
//import com.project.repository.StockRepository;
//import com.project.repository.StocksInFundRepsoitory;
//
//@Service
//public class MutualFundService {
//
//	@Autowired
//	MutualFundRepository mfRepository;
//	@Autowired
//	StocksInFundRepsoitory sifRepository;
//	@Autowired
//	StockRepository sRepository;
//	
//	
//	public ArrayList<MutualFund> getAllMutualFunds(){
//		return (ArrayList<MutualFund>) mfRepository.findAll();
//	}
//	
//	public String addAMutualFund(MutualFund newMutualFund) {
//		 mfRepository.save(newMutualFund);
//		 
//		 return "Mutual Fund has been successfully added!";
//	}
//	
//	public MutualFund getMutualFundInfo(int mfid) {
//		return mfRepository.findOne(mfid);
//	}
//
//	public ArrayList<StockInfo> getStockComposition(int mfid) {
//		
//		ArrayList<StocksInFund> allStocksWeight= new ArrayList<StocksInFund>();
//		ArrayList<StockInfo> allStockInfo = new ArrayList<StockInfo>();
//		
//		Stock stock= null;
//		
//		for(StocksInFund sif : sifRepository.findAll()) {
//			if(sif.getIdentifier().fundId == mfid) {
//				allStocksWeight.add(sif);
//				StockInfo stockInfo = new StockInfo();
//				stockInfo.setStockId(sif.getIdentifier().stockId);
//				stockInfo.setStockWeight(sif.getStockWeight());
//				stock= sRepository.findOne(sif.getIdentifier().stockId);
//				stockInfo.setStockName(stock.getStockTicker());
//				stockInfo.setClosingPrice(stock.getClosingPrice());
//				allStockInfo.add(stockInfo);
//			}
//		}
//		System.out.println(allStockInfo);
////		return allStocksWeight;
//		return allStockInfo;
//	}
//	
//}




package com.project.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.MutualFund;
import com.project.Stock;
import com.project.StockInfo;
import com.project.StocksInFund;
import com.project.repository.InvestmentRepository;
import com.project.repository.MutualFundRepository;
import com.project.repository.StockRepository;
import com.project.repository.StocksInFundRepsoitory;

@Service
public class MutualFundService {

	@Autowired
	MutualFundRepository mfRepository;
	@Autowired
	StocksInFundRepsoitory sifRepository;
	@Autowired
	StockRepository sRepository;
	@Autowired
	InvestmentService ivService;

	public ArrayList<MutualFund> getAllMutualFunds() {
		return (ArrayList<MutualFund>) mfRepository.findAll();
	}

	public MutualFund createMutualFund(MutualFund mutualFundDetails) {
//		  Date curr_date = new Date();
//        MutualFund mutualFund = new MutualFund();
//        mutualFund.setFundName(mutualFundDetails.getFundName());
//        mutualFund.setExpenseRatio(mutualFundDetails.getExpenseRatio());
//        mutualFund.setCurrentNAV(mutualFundDetails.getCurrentNAV());
//        mutualFund.setExitLoad(mutualFundDetails.getExitLoad());
		mutualFundDetails.setAssetsUnderManagement(1000000000);
		mutualFundDetails.setManagerId(1);
		mutualFundDetails.setInceptionDate(new Date());

		// Save the mutual fund details to get the fundId
		MutualFund mfund = mfRepository.save(mutualFundDetails);
		return mfund;
	}
	
	public MutualFund getMutualFundInfo(int mfid) {
		return mfRepository.findOne(mfid);
	}
	

	public ArrayList<StockInfo> getStockComposition(int mfid) {

		ArrayList<StocksInFund> allStocksWeight = new ArrayList<StocksInFund>();
		ArrayList<StockInfo> allStockInfo = new ArrayList<StockInfo>();

		Stock stock = null;

		for (StocksInFund sif : sifRepository.findAll()) {
			if (sif.getIdentifier().fundId == mfid) {
				allStocksWeight.add(sif);
				StockInfo stockInfo = new StockInfo();
				stockInfo.setStockId(sif.getIdentifier().stockId);
				stockInfo.setStockWeight(sif.getStockWeight());
				stock = sRepository.findOne(sif.getIdentifier().stockId);
				stockInfo.setStockName(stock.getStockTicker());
				stockInfo.setClosingPrice(stock.getClosingPrice());
				allStockInfo.add(stockInfo);
			}
		}
		System.out.println(allStockInfo);
//		return allStocksWeight;
		return allStockInfo;
	}
	
	
	public ArrayList<MutualFund> getListOfInvestedMutualFundsByInvestor(int investorId){
		
		Iterable<Integer> ids= ivService.getDistinctFundIdsByInvestorId(investorId);
		return (ArrayList<MutualFund>) mfRepository.findAll(ids);
		
	}

}

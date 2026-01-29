package com.project;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Investment")
public class Investment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="investmentId", insertable=false, updatable=false)
	int investmentId;
	int investorId, fundId;
	double amountInvested;
	double units;
	
	
	@Column(name="Transaction_Type")
	String transactionType;
	
	@Temporal(TemporalType.DATE)
	Date dateOfInvestment;
	
	@PrePersist
	protected void onCreate() {
		dateOfInvestment= new Date();
	}
	
	public Investment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Investment(int investmentId, int investorId, int fundId, double amountInvested, String transactionType, double units,
			Date dateOfInvestment) {
		super();
		this.investmentId = investmentId;
		this.investorId = investorId;
		this.fundId = fundId;
		this.amountInvested = amountInvested;
		this.transactionType = transactionType;
		this.dateOfInvestment = dateOfInvestment;
		this.units=units;
	}

	public int getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}

	public int getInvestorId() {
		return investorId;
	}

	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}

	public int getFundId() {
		return fundId;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}

	public double getAmountInvested() {
		return amountInvested;
	}

	public void setAmountInvested(double amountInvested) {
		this.amountInvested = amountInvested;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getDateOfInvestment() {
		return dateOfInvestment;
	}

	public void setDateOfInvestment(Date dateOfInvestment) {
		this.dateOfInvestment = dateOfInvestment;
	}
	
	public double getUnits() {
		return units;
	}

	public void setUnits(double units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return "Investment [investmentId=" + investmentId + ", investorId=" + investorId + ", fundId=" + fundId
				+ ", amountInvested=" + amountInvested + ", units=" + units + ", transactionType=" + transactionType
				+ ", dateOfInvestment=" + dateOfInvestment + "]";
	}


	
	
	
}

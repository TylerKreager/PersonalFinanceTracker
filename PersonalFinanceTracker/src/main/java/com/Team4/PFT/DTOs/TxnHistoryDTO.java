package com.Team4.PFT.DTOs;

import java.time.LocalDate;
import java.util.UUID;

import com.Team4.PFT.TxnHistory;

public class TxnHistoryDTO {
	private UUID txnId;
	private LocalDate txnDate;
	private String description;
	private String subDescription;
	private String txnType;
	private Double txnAmount;
	private double balance;
	
	public TxnHistoryDTO(TxnHistory txn) {
		this.txnId = txn.getTxnId();
		this.txnDate = txn.getTxnDate();
		this.description = txn.getDescription();
		this.subDescription = txn.getSubDescription();
		this.txnType = txn.getTxnType();
		this.txnAmount = txn.getTxnAmount();
		this.balance = txn.getBalance();
	}

	public TxnHistoryDTO(UUID txnId, LocalDate txnDate, String description, String subDescription, String txnType,
			Double txnAmount, double balance) {
		super();
		this.txnId = txnId;
		this.txnDate = txnDate;
		this.description = description;
		this.subDescription = subDescription;
		this.txnType = txnType;
		this.txnAmount = txnAmount;
		this.balance = balance;
	}

	public UUID getTxnId() {
		return txnId;
	}

	public void setTxnId(UUID txnId) {
		this.txnId = txnId;
	}

	public LocalDate getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(LocalDate txnDate) {
		this.txnDate = txnDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubDescription() {
		return subDescription;
	}

	public void setSubDescription(String subDescription) {
		this.subDescription = subDescription;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Double getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(Double txnAmount) {
		this.txnAmount = txnAmount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	
	
	
	
}

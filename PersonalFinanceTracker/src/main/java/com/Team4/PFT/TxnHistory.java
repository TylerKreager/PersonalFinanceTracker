package com.Team4.PFT;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="txnHistory")
public class TxnHistory {

	@Id
	@Column(columnDefinition = "CHAR(36)")
	private UUID txnId;
	
	@ManyToOne
	@JoinColumn(name = "userId", nullable=false)
	private User user;
	
	@NotNull
	private LocalDate txnDate;
	
	@NotNull
	private String description;
	
	@NotNull
	private String subDescription;
	
	@NotNull
	private String txnType;
	
	@NotNull
	private double txnAmount;
	
	@NotNull
	private double balance;
	
	public TxnHistory() {
		super();
	}

	public UUID getTxnId() {
		return txnId;
	}

	public void setTxnId(UUID txnId) {
		this.txnId = txnId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public double getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(double txnAmount) {
		this.txnAmount = txnAmount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}

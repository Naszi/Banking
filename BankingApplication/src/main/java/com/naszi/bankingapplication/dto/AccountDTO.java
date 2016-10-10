package com.naszi.bankingapplication.dto;

public class AccountDTO {

	private String accountId;
	private String accountNumber;
	private double balance;
	private String currency;
	private String customerId;

	public AccountDTO() {
	}

	public AccountDTO(double balance, String accountNumber) {
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public AccountDTO(String accountId, String accountNumber, double balance, String currency, String customerId) {
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.currency = currency;
		this.customerId = customerId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public double withDrawMoney(double amount) {
		return this.balance = this.balance - amount;
	}

	public double addMonney(double amount) {
		return this.balance = this.balance + amount;
	}

}

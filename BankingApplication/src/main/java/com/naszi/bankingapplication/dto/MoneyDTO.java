package com.naszi.bankingapplication.dto;

public class MoneyDTO {

	private int accountNumber;
	private double balance;

	public MoneyDTO() {
	}
	
	public MoneyDTO(double balance, int accountNumber) {
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double withDrawMoney(double amount) {
		return this.balance = this.balance - amount;
	}
	
	public double addMonney(double amount) {
		return this.balance = this.balance + amount;
	}


}

package com.naszi.bankingapplication.dto;

public class BankStatisticsDTO {

	private int numberOfCustomer;
	private int numberOfAccount;
	private int moneyInBank;
	private double avarageBalanceCustomer;
	private double avarageBalanceAccount;

	public BankStatisticsDTO() {
	}

	public BankStatisticsDTO(int numberOfCustomer, int accountOfNumber, int moneyInBank, double avarageBalanceCustomer,
			double avarageBalanceAccount) {
		this.numberOfCustomer = numberOfCustomer;
		this.numberOfAccount = accountOfNumber;
		this.moneyInBank = moneyInBank;
		this.avarageBalanceCustomer = avarageBalanceCustomer;
		this.avarageBalanceAccount = avarageBalanceAccount;
	}

	public double getAvarageBalanceCustomer() {
		return avarageBalanceCustomer;
	}

	public void setAvarageBalanceCustomer(double avarageBalanceCustomer) {
		this.avarageBalanceCustomer = avarageBalanceCustomer;
	}

	public double getAvarageBalanceAccount() {
		return avarageBalanceAccount;
	}

	public void setAvarageBalanceAccount(double avarageBalanceAccount) {
		this.avarageBalanceAccount = avarageBalanceAccount;
	}

	public int getNumberOfCustomer() {
		return numberOfCustomer;
	}

	public void setNumberOfCustomer(int numberOfCustomer) {
		this.numberOfCustomer = numberOfCustomer;
	}

	public int getNumberOfAccount() {
		return numberOfAccount;
	}

	public void setNumberOfAccount(int numberOfAccount) {
		this.numberOfAccount = numberOfAccount;
	}

	public int getMoneyInBank() {
		return moneyInBank;
	}

	public void setMoneyInBank(int moneyInBank) {
		this.moneyInBank = moneyInBank;
	}

}

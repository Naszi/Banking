package com.naszi.bankingapplication.dto;

public class AllCustomerDTO {

	private String name;
	private String address;
	private String birthday;
	private String accountNumber;
	private double balance;
	private String currency;

	public AllCustomerDTO() {
	}

	public AllCustomerDTO(String name, String address, String birthday, String accountNumber, double balance,
			String currency) {
		this.name = name;
		this.address = address;
		this.birthday = birthday;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.currency = currency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

}

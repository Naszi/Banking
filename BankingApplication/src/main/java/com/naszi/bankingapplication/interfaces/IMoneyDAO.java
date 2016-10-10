package com.naszi.bankingapplication.interfaces;

public interface IMoneyDAO<Collection> {

	public boolean withDrawMoney(Collection c, double amount);

	public boolean addMoney(Collection c, double amount);

	public boolean numberOfCustomers();

	public boolean numberOfAccount();

	public boolean moneyInBank();
}

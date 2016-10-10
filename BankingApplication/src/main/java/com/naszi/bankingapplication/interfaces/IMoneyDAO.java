package com.naszi.bankingapplication.interfaces;

public interface IMoneyDAO<Collection> {

	public boolean withDrawMoney(Collection c, double amount);

	public boolean addMoney(Collection c, double amount);
	
	public boolean transferMoney(Collection from, Collection to, double amount);

}
